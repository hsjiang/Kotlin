package com.example.kotlin.chapter9

import kotlinx.coroutines.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

//协程的创建与启动
fun main() {
    launchFun()
}

fun launchFun() = runBlocking(CoroutineName("IIIRunBLocking")) {
    launch(Dispatchers.IO + CoroutineName("IIILaunch")) {
        println("waiting 200")
        launch(Dispatchers.Default + CoroutineName("IIIILaunch")) {
            delay(200)
        }
    }
}