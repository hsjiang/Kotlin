package com.example.kotlin.chapter9

import kotlinx.coroutines.*

fun main(args: Array<String>) {
    testDispatchersAndThreads()

//    testRunBlockingWithSpecifiedContext()

//    testChildrenCoroutine()

//    unconfinedFun()
}

//协程上下文包含一个协程调度程序，他可以指定由哪个线程来执行协程
fun testDispatchersAndThreads() = runBlocking {
    val jobs = arrayListOf<Job>()
    jobs += launch(Dispatchers.Unconfined) {
        println("Unconfined: I'm working in thread ${Thread.currentThread()}")
        delay(1)
        println("Unconfined: After delay I'm working in thread ${Thread.currentThread()}")
    }
    jobs += launch(coroutineContext) {
        println("coroutineContext: I'm working in thread ${Thread.currentThread()}")
    }
    jobs += launch(Dispatchers.Default) {
        println("Default: I'm working in thread ${Thread.currentThread()}")
    }
    jobs += launch(Dispatchers.IO) {
        println("IO: I'm working in thread ${Thread.currentThread()}")
    }
    jobs += launch(newSingleThreadContext("myThread")) {
        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread()}")
    }

    jobs.forEach { it.join() }
}

fun log(msg: String) = println("${Thread.currentThread()} $msg")

//使用runBlocking时显式地指定上下文,同时使用withContext函数更改协程的上下文
fun testRunBlockingWithSpecifiedContext() = runBlocking {
    log("$coroutineContext")
    log("${coroutineContext[Job]}")
    log("开始")
    val context1 = newSingleThreadContext("线程A")
    val context2 = newSingleThreadContext("线程B")
    runBlocking(context1) {
        log("Started in context1")
        withContext(context2) {
            log("Work in context2")
        }
        log("Back to context1")
    }
    log("结束")
}

//父子协程
fun testChildrenCoroutine() = runBlocking {
    var job1: Job? = null
    var job2: Job? = null
    val request = launch(Dispatchers.Default) {
        log("Context1: $coroutineContext")

        job1 = launch(Dispatchers.Default) {
            log("job1:独立的上下文")
            delay(1000L)
            log("job1:不会受到request.cancel()的影响")
        }

        //继承父上下文 request 的 context
        job2 = launch(coroutineContext) {
            log("Context2: $coroutineContext")
            log("job2:是request coroutine 的子协程")
            delay(1000L)
            log("job2:当request.cancel(),job2也会被取消")
        }

        job1?.join()
        job2?.join()
    }
    delay(500L)
    request.cancel()
    jobStatus("job1: ", job1)
    jobStatus("job2: ", job2)
    delay(1000L)
    println("main: who has survived request cancellation?")
}

fun jobStatus(msg: String, job: Job?) {
    println("$msg: ${job?.isActive},${job?.isCompleted},${job?.isCancelled}")
}

//specify coroutine name,this name is used in debugging mode
fun specifyCoroutineName() = runBlocking {
    val job = async(CoroutineName("123")) {
        delay(2000)
        println("job complete")
    }
    job.await()
}

fun unconfinedFun() = runBlocking {
    withContext(Dispatchers.Unconfined) {
        println(1)
        withContext(Dispatchers.Unconfined) { // Nested unconfined
            println(2)
        }
        println(3)
    }
    println("Done")
}
