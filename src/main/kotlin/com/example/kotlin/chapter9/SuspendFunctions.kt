package com.example.kotlin.chapter9

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
//    testSequential()

    testAsync()
}

fun testSequential() = runBlocking {
    val time = measureTimeMillis {
        val time1 = doJob1()
        val time2 = doJob2()
        println("[testSequential]: ${time1 + time2}")
    }

    println("[testSequential]: complete in $time ms")
}

fun testAsync() = runBlocking {
    val time = measureTimeMillis {
        val time1 = async { doJob1() }
        val time2 = async { doJob2() }
        println("${time1.isActive}, ${time1.isCompleted}, ${time1.isCancelled && time1.isCompleted}, ${time1.isCancelled}")
        println("[testSequential]: ${time1.await() + time2.await()}")
        println("${time1.isActive}, ${time1.isCompleted}, ${time1.isCancelled && time1.isCompleted}, ${time1.isCancelled}")
    }

    println("[testSequential]: complete in $time ms")
}

suspend fun doJob1(): Int {
    println("doing job1...")
    delay(1000L)
    println("job1 done...")
    return 10
}

suspend fun doJob2(): Int {
    println("doing job2...")
    delay(2000L)
    println("job2 done...")
    return 20
}