package com.example.kotlin.chapter9

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

fun main() {
//    useSequenceToCompute()
//    flowList()
//    flowIsCold()
//    cancelOfFlow()
}

private fun useSequenceToCompute() {
    val sequence = sequence<String> {
        for (i in 1..3) {
            println("waiting for caculate")
            Thread.sleep(1500)
            yield(i.toString())
        }
    }

    println("start forEach")
    sequence.forEach {
        println("print $it")
        Thread.sleep(500)
    }
}

private fun foo(): Flow<Int> = flow {
    println("flow started")
    for (i in 1..3) {
        delay(1000)
        println("emit a value:$i")
        emit(i)
    }
}

private fun flowList() = runBlocking {
    println("waiting collection")
    delay(2000)
    foo().collect {
        println("$it")
    }
}

//流是冷的
private fun flowIsCold() = runBlocking {
    println("Calling foo...")
    val flow = foo()
    println("Calling collect...")
    flow.collect { value -> println(value) }
    println("Calling collect again...")
    flow.collect { value -> println(value) }
}

//流的取消
private fun cancelOfFlow() = runBlocking<Unit> {
    withTimeoutOrNull(2500) {
        foo().collect { value -> println(value) }
    }
    println("Done")
}

private fun flowOfBuilder() = runBlocking {
    flowOf(1, 2, 3, 4, 5).collect {
        println("value: $it")
    }
}

private fun asFlowBuilder() = runBlocking {
    arrayListOf(1, 2, 3, 4, 5).asFlow().collect {
        println("value: $it")
    }
    (1..8).asFlow().collect {
        println("value: $it")
    }
}
