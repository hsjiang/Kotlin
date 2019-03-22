package com.example.kotlin.chapter9

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
//    testChannel()
    testClosingAndIterationChannels()
}

//通道的概念类似于阻塞队列(Blocking-Queue很好的解决了多线程中如何高效安全的"传输"数据的问题)，
//通道和阻塞队列的关键区别是:通道有挂起的操作而不是阻塞的，同时他可以关闭
fun testChannel() = runBlocking {
    val channel = Channel<Int>()
    launch(Dispatchers.Default) {
        for (x in 1..10) channel.send(x * x)
    }
    println("channel = $channel")
    repeat(10) {
        println(channel.receive())
    }
    println("Done!")
}

fun testClosingAndIterationChannels() = runBlocking {
    val channel = Channel<Int>()
    launch(Dispatchers.Default) {
        for (x in 1..5) channel.send(x * x)
        channel.close()
    }
    println("channel = $channel")
    for (x in channel) println(x)
    println("Done!")
}