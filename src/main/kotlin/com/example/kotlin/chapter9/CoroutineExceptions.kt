package com.example.kotlin.chapter9

import kotlinx.coroutines.*
import java.io.IOException
import java.lang.AssertionError
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    exception1()
//    exception2()
//    suppressedException()
//    exceptionHandler()
}

private val uncaughtExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    println("caught ${throwable}")
}

private fun exception1() = runBlocking {
    val job = GlobalScope.launch {
        delay(1000)
        println("Throwing exception from launch")
        throw IndexOutOfBoundsException()
    }
    job.join()
    println("Joined failed job")
    val deferred = GlobalScope.async {
        delay(2000)
        println("Throwing exception from async")
        throw ArithmeticException()
    }
    try {
        deferred.await()
        println("Unreached")
    } catch (e: ArithmeticException) {
        println("Caught ArithmeticException")
    }
}

private fun exception2() = runBlocking {
    val job = SupervisorJob()
    with(CoroutineScope(coroutineContext + job)) {
        val child1 = launch(uncaughtExceptionHandler) {
            println("child1 throw a ArithmeticException")
            throw ArithmeticException()
        }
        val child2 = launch {
            child1.join()
            println("child1 is cancelled: ${child1.isCancelled}, but second one is still active")
            try {
                delay(Long.MAX_VALUE)
            } finally {
                // 但是取消了监督的传播
                println("Second child is cancelled because supervisor is cancelled")
            }
        }
        child1.join()
        job.cancel()
        child2.join()
    }
    delay(1000)
    println("Parent is not cancelled")
}

private fun exceptionHandler() = runBlocking {
    val job = GlobalScope.launch(uncaughtExceptionHandler) {
        launch { // 第一个子协程
            try {
                delay(200000)
            } finally {
                withContext(NonCancellable) {
                    println("Children are cancelled, but exception is not handled until all children terminate")
                    delay(100)
                    println("The first child finished its non cancellable block")
                }
            }
        }
        launch { // 第二个子协程
            delay(10)
            println("Second child throws an exception")
            throw ArithmeticException()
        }
        try {
            delay(Long.MAX_VALUE)
        } finally {
            // 但是取消了监督的传播
            println("Second child is cancelled because supervisor is cancelled")
        }
    }
    job.join()
}

//异常聚合
private fun suppressedException() = runBlocking {
    val uncaughtExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("caught $throwable with suppressed ${throwable.suppressed?.contentToString()}")
    }
    val job = GlobalScope.launch(uncaughtExceptionHandler) {
        launch { // 第一个子协程
            try {
                delay(200000)
            } finally {
                throw ArithmeticException()
            }
        }
        launch { // 第二个子协程
            delay(10)
            println("Second child throws an exception")
            throw IOException()
        }
    }
    job.join()
}