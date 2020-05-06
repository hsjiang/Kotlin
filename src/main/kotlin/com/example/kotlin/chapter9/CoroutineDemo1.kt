package com.example.kotlin.chapter9

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    firstCoroutineMethod1()
}

fun firstCoroutineMethod1() = runBlocking {
    val c1 = launch {
        delay(3000)
        println("hello, ")
    }
//    c1.join()
    delay(3000)
    println("world! ")
}
