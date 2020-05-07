package com.example.kotlin.chapter9

import kotlinx.coroutines.*

fun main(args: Array<String>) {
    coroutineDaemon()
//    GlobalScopeDeamon()
    println("end")
}

fun daemonThread() {
    val t = Thread {
        repeat(10) { i ->
            println("im sleeping $i ...")
            Thread.sleep(500)
        }
    }
//    t.isDaemon = true
    t.start()
    Thread.sleep(2000)
}

fun coroutineDaemon() = runBlocking {
    launch(Dispatchers.Default) {
        repeat(10) { i ->
            println("im sleeping $i ...")
            delay(500)
        }
    }
    delay(2000)
}

//全局协程像守护线程
fun GlobalScopeDeamon() = runBlocking {
    GlobalScope.launch {
        repeat(1000) { i ->
            delay(500L)
            println("I'm sleeping $i...")
        }
    }
    delay(1300L) // 在延迟后退出
}

