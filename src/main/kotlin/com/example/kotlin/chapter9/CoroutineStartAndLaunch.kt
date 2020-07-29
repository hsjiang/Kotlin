package com.example.kotlin.chapter9

import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.invokeOnCompletion
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.intercepted
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn

//协程的创建与启动
fun main() {
//    launchFun()
//    suspendAndResume()
//    launchADelay()
    yieldFun()
}

fun launchFun() = runBlocking(CoroutineName("IIIRunBLocking")) {
    launch(Dispatchers.IO + CoroutineName("IIILaunch")) {
        println("waiting 2000")
        launch(Dispatchers.IO + CoroutineName("IIIILaunch")) {
            delay(2000)
            println("finished")
        }
    }
}

fun suspendAndResume() = runBlocking {
    launch(Dispatchers.Unconfined) {
        println("${Thread.currentThread().name} : launch start")
        async(Dispatchers.Default) {
            println("${Thread.currentThread().name} : async start")
            delay(100)
            println("${Thread.currentThread().name} : async end")
        }.await()
        println("${Thread.currentThread().name} : launch end")
    }
}

fun launchADelay() = runBlocking {
    launch(Dispatchers.IO + CoroutineName("haha IO")) {
        delay(3000)
        yield()
    }
}

fun yieldFun() = runBlocking {
    launch(Dispatchers.IO) {
        launch(CoroutineName("I Launch")) {
            var i = 0
            while (i < 10) {
                println("i: $i")
                i++
                delay(1000)
                yield()
            }
        }
        launch(CoroutineName("N Launch")) {
            var n = 0
            while (n < 10) {
                println("n: $n")
                n++
                delay(1000)
                yield()
            }
        }
    }
}

suspend fun suspendCoroutineFun() = suspendCoroutine<String> {

}

suspend fun suspendCancellableCoroutineFun() = suspendCancellableCoroutine<String> {

}

suspend fun suspendUORFun() = suspendCoroutineUninterceptedOrReturn<String> {
    it.resumeWith(Result.success("success"))
}