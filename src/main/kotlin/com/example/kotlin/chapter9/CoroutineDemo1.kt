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
        delay(TimeUnit.MILLISECONDS.toMillis(3000))
        println("hello, ")
    }

    println("world! ")
    c1.join()

    withTimeout(3000) {

    }

    val mills = measureTimeMillis {
            
    }
}
