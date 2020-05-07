package com.example.kotlin.chapter9

import kotlinx.coroutines.*

fun main() {
//    timeout1()
    timeout2()
}

fun timeout1() = runBlocking {
    try {
        withTimeout(1300) {
            repeat(1000) {
                println("I'm sleeping $it ...")
                delay(500L)
            }
        }
    } catch (e: TimeoutCancellationException) {
        println("timeout")
    }
}

fun timeout2() = runBlocking {
    val result = withTimeoutOrNull(1300) {
        repeat(1000) {
            println("I'm sleeping $it ...")
            delay(500L)
        }
        "Done"
    }
    println("result: $result")
}