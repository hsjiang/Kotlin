package com.example.kotlin.chapter9

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main(args: Array<String>) {
    globalLaunch2()
//    globalLaunch3()
//    coroutineScope1()
    println("end")
}

private fun globalLaunch() {
    GlobalScope.launch(Dispatchers.Default, CoroutineStart.DEFAULT) {
        delay(1000)
        print(" world!")
    }
    print("hello, ")
    Thread.sleep(2000)
}

private fun globalLaunch2() = runBlocking {
    GlobalScope.launch {
        delay(1000)
        println(" world!")
        println(" Thread: ${Thread.currentThread().name}")
    }
    print("hello, ")
    delay(2000)
}

private fun globalLaunch3() = runBlocking {
    val job = GlobalScope.launch {
        delay(1000)
        println(" world!")
    }
    print("hello, ")
    job.join()
}

private fun globalLaunch4() = runBlocking {
    launch {
        delay(1000)
        println(" world!")
    }
    print("hello, ")
}

private fun coroutineScope1() = runBlocking {
    // 在 runBlocking 作用域中启动新协程
    launch {
        delay(200L)
        println("Task from runBlocking")
    }

    // 创建一个新的协程作用域
    coroutineScope {
        doWork(coroutineContext)
    }
}

suspend fun doWork(context: CoroutineContext) {
    CoroutineScope(context).launch {
        delay(500L)
        println("Task from nested launch")
    }
    delay(100L)
    println("Coroutine scope is over")
}