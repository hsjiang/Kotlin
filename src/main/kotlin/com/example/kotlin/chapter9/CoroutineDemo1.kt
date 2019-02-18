package com.example.kotlin.chapter9

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    firstCoroutineMethod1()
}

fun firstCoroutineMethod1() = runBlocking {
    val c1 = launch {
        delay(3000, TimeUnit.MILLISECONDS)
        println("hello, ")
    }
    val c2 = async {
        return@async "hello"
    }
    println("world! ")
//    c1.join()

}
