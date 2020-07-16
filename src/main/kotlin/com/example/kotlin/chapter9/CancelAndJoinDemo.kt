package com.example.kotlin.chapter9

import kotlinx.coroutines.*

fun main() {
//    fun2()
//    joinFun()
    deferredReturnFun()
}

fun fun1() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L) // 延迟一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并且等待它结束
    println("main: Now I can quit.")
}

fun fun2() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try {
            var nextPrintTime = startTime
            var i = 0
            while (isActive && i < 100) { // 一个执行计算的循环，只是为了占用 CPU
                // 每秒打印消息两次
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        } finally {
            println("job: I'm running finally")
            withContext(NonCancellable) {
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // 等待一段时间
    println("main: I'm tired of waiting!")
    job.cancel()
    job.join()
//    job.cancelAndJoin() // 取消一个作业并且等待它结束
    println("main: Now I can quit.")
}

fun joinFun() = runBlocking {
    val job1 = launch {
        delay(2000)
        println("I'm first launch")
    }
    println("I'm waiting")
    job1.join()
    launch {
        delay(1000)
        println("I'm second launch")
    }
}

fun deferredReturnFun() = runBlocking {
    val a1 = async {
        delay(2000)
        println("get value success")
        "value"
    }
    println("I'm waiting")
    println("Value:${a1.await()}")
    println("finished")
}