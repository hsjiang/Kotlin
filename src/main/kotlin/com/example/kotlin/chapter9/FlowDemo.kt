package com.example.kotlin.chapter9

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() {
    useSequenceToCompute()
//    flowList()
//    flowIsCold()
//    cancelOfFlow()
//    opTransform()
//    opTake()
//    terminalOperators()
//    opZip()
    flatteningFlows()
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

//转换操作符
private fun opTransform() = runBlocking {
    val performRequest: suspend (request: Int) -> String = { request ->
        delay(1000)
        "response $request"
    }

    (1..3).asFlow() // 一个请求流
            .transform { request ->
                emit("Making request $request")
                emit(performRequest(request))
            }
            .collect { response -> println(response) }
}

//限长操作符
private fun opTake() = runBlocking {
    flow {
        try {
            emit(1)
            emit(2)
            println("This line will not execute")
            emit(3)
        } finally {// do finally after cancellationException
            println("Finally in numbers")
        }
    }.take(2)
            .collect {
                println("value: $it")
            }
}

//末端流操作符
private fun terminalOperators() = runBlocking {
    val flow = (1..5).asFlow()
    val list = mutableListOf<Int>()
    val set = HashSet<Int>()
    flow.toList(list)
    flow.toCollection(list)
    flow.toSet(set)

    println("first even: " + flow.first { it % 2 == 0 })
    println("single value: " + flow { emit(1) }.single())

    val sum = flow.map { it * it }
            .reduce { accumulator, value ->
                accumulator + value
            }
    println("sum: $sum")

    val foldSum = flow.map {
        it * it
    }.fold(5) { acc, value ->
        acc + value
    }
    println("foldSum: $foldSum")

    flow.onEach { println("onEach: $it") }.launchIn(this)
}

private fun opFlowOn() = runBlocking {
    flow {
        println("Thread: ${Thread.currentThread().name}")
        for (i in 1..3) {
            emit(i)
        }
    }.flowOn(Dispatchers.Default)
            .collect {
                println("value: $it")
            }
}

private fun opZip() = runBlocking {
    val nums = (1..3).asFlow().onEach { delay(300) } // 发射数字 1..3，间隔 300 毫秒
    val strs = flowOf("one", "two", "three", "four").onEach { delay(400) } // 每 400 毫秒发射一次字符串
    val startTime = System.currentTimeMillis() // 记录开始的时间
    nums.zip(strs) { a, b -> "$a -> $b" } // 使用“zip”组合单个字符串
            .collect { value -> // 收集并打印
                println("$value at ${System.currentTimeMillis() - startTime} ms from start")
            }
}

//Flattening flows
private fun flatteningFlows() = runBlocking {
    val requestFlow: (i: Int) -> Flow<String> = { i ->
        flow {
            emit("$i: First")
            delay(500) // 等待 500 毫秒
            emit("$i: Second")
        }
    }

//    (1..3).asFlow().map { requestFlow(it) }

    val startTime = System.currentTimeMillis() // 记录开始时间
    (1..3).asFlow().onEach { delay(100) } // 每 100 毫秒发射一个数字
            .flatMapConcat { requestFlow(it) }
            .collect { value -> // 收集并打印
                println("$value at ${System.currentTimeMillis() - startTime} ms from start")
            }
}

//buffer 缓冲，并发运行 flow 中发射元素的代码以及收集的代码， 而不是顺序运行它们
//conflated 当流代表部分操作结果或操作状态更新时，可能没有必要处理每个值，而是只处理最新的那个.它通过删除发射值来实现。
//collectLatest 处理最新值，实现方式是取消缓慢的收集器，并在每次发射新值的时候重新启动它
//zip 组合两个流中的相关值
//combine 当流表示一个变量或操作的最新值时（请参阅相关小节 conflation），可能需要执行计算，这依赖于相应流的最新值，并且每当上游流产生值的时候都需要重新计算
//flatMapConcat 连接模式由 flatMapConcat 与 flattenConcat 操作符实现。它们是相应序列操作符最相近的类似物。它们在等待内部流完成之前开始收集下一个值
//flatMapMerge 另一种展平模式是并发收集所有传入的流，并将它们的值合并到一个单独的流，以便尽快的发射值。 它由 flatMapMerge 与 flattenMerge 操作符实现
//flatMapLatest 在发出新流后立即取消先前流的收集
/**
 * catch
 * 透明捕获:
 *  过渡操作符遵循异常透明性，仅捕获上游异常（catch 操作符上游的异常，但是它下面的不是）。 如果 collect { ... } 块（位于 catch 之下）抛出一个异常
 * 声明式捕获:
 *  我们可以将 catch 操作符的声明性与处理所有异常的期望相结合，将 collect 操作符的代码块移动到 onEach 中，并将其放到 catch 操作符之前。收集该流必须由调用无参的 collect() 来触发
 */

/**
 * onCompletion
 * 操作符与 catch 不同，它不处理异常。我们可以看到前面的示例代码，异常仍然流向下游。它将被提供给后面的 onCompletion 操作符，
 * 并可以由 catch 操作符处理
 * 与 catch 操作符一样，onCompletion 仅能观察到来自上游的异常而不能观察到下游的异常
 */

/**
 * 启动流
 * 使用 collect 末端操作符，那么后面的代码会一直等待直至流被收集
 * 使用 launchIn 替换 collect 我们可以在单独的协程中启动流的收集
 * 在实际的应用中，作用域来自于一个寿命有限的实体。在该实体的寿命终止后，相应的作用域就会被取消，即取消相应流的收集。
 * 这种成对的 onEach { ... }.launchIn(scope) 工作方式就像 addEventListener 一样。而且，
 * 这不需要相应的 removeEventListener 函数， 因为取消与结构化并发可以达成这个目的。
 * 注意，launchIn 也会返回一个 Job，可以在不取消整个作用域的情况下仅取消相应的流收集或对其进行 join
 */
