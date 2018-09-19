package com.example.kotlin.chapter4

//Kotlin也是面向表达式的语言。在Kotlin中所有控制流语句都是表达式（除了变量赋值、异常等）。
//Kotlin中的Unit类型实现了与Java中的void一样的功能。不同的是，当一个函数没有返回值的时候，我们用Unit来表示这个特征，而不是null

//Unit与Nothing之间的区别: Unit类型表达式计算结果的返回类型是Unit。
// Nothing类型的表达式计算结果是永远不会返回的（跟Java 中的void相同）
fun main(args: Array<String>) {
    val helloUnit = printUnit();
    println(helloUnit)
}

fun printUnit() {
    println("Hello,Unit")
}

fun formatCell(value: Double): String =
        if (value.isNaN())
            throw IllegalArgumentException("$value is not a number")  // Nothing
        else
            value.toString()