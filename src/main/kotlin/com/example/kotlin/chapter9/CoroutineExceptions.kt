package com.example.kotlin.chapter9

import kotlinx.coroutines.*

fun main() {
    exception2()
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
    val job = CoroutineScope(Dispatchers.Default).launch {
        val child = launch(uncaughtExceptionHandler) {
            delay(1000)
            throw ArithmeticException()
        }
        child.join()
        println("Parent is not cancelled")
    }
    job.join()
}

private fun exceptionHandler() = runBlocking {
    val job = GlobalScope.launch(uncaughtExceptionHandler) {
        launch { // 第一个子协程
            try {
                delay(Long.MAX_VALUE)
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
    }
    job.join()
}