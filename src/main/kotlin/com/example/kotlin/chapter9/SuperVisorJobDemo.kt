package com.example.kotlin.chapter9

import kotlinx.coroutines.*

fun main() {
    useSupervisorJob()
//    useSupervisorScope()
}

/**
 * 子协程异常取消时，其他子协程不受影响
 * GlobalScope
 * superVisorScope
 * CoroutineScope(SupervisorJob())
 */
private fun useSupervisorJob() = runBlocking {
    val supervisor = SupervisorJob()
    with(CoroutineScope(coroutineContext + supervisor)) {
        // 启动第一个子作业——这个示例将会忽略它的异常（不要在实践中这么做！）
        val firstChild = launch(CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Caught First child exception: ${throwable}")
        }) {
            println("First child is failing")
            throw AssertionError("First child is cancelled")
        }

        val secondChild = launch {
            firstChild.join()
            // 取消了第一个子作业且没有传播给第二个子作业
            println("First child is cancelled: ${firstChild.isCancelled}, but second one is still active")
            try {
                delay(Long.MAX_VALUE)
            } finally {
                // 但是取消了监督的传播
                println("Second child is cancelled because supervisor is cancelled")
            }
        }
        // 等待直到第一个子作业失败且执行完成
        firstChild.join()
        println("Cancelling supervisor")
        supervisor.cancel()
        secondChild.join()
    }
}

private fun useSupervisorScope() = runBlocking {
    supervisorScope {
        launch(CoroutineExceptionHandler { _, exception ->
            println("caught exception: ${exception}")
        }) {
            try {
                println("child throws an exception")
                throw AssertionError()
            } finally {
                println("Child is cancelled")
            }
        }
        println("supervisorScope is completing")
    }
    println("scope is completed")
}