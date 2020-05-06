package com.example.kotlin.chapter9

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
//    runBlocking {
//        GlobalScope.launch {
//            delay(2000)
//            println("global scope launched")
//        }
//
//        println("delay wait for global launch")
//        delay(2000)
//    }

    runBlocking {
        val job = GlobalScope.launch {
            delay(2000)
            println("global scope launched")
        }

        println("wait for launch")
        job.join()
    }

    println("finish")
}