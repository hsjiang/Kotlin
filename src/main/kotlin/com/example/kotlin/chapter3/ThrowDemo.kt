package com.example.kotlin.chapter3

//kotlin中throw是表达式，它的类型是特殊类型:Nothing,该类型没有值 与void一样

fun main(args: Array<String>) {
    println(Nothing::class)

    println()
//    throwDemo1("my exception")

    //exception变量时Nothing类型，没有任何值，因此不能当做参数传递给函数
    val exception = throw NullPointerException()
//    println(exception)
}

fun throwDemo1(msg: String): Nothing {
    throw IllegalArgumentException(msg)
}
