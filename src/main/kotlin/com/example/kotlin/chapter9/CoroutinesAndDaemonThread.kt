package com.example.kotlin.chapter9

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
//    daemonThread()
    coroutineDaemon()
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

