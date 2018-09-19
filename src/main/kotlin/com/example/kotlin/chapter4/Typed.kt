package com.example.kotlin.chapter4

//Koltin是一门强类型的、静态类型、支持隐式类型的显式类型语言

fun main(args: Array<String>) {
    var a = 1_000_000
    var b = 1000000
    println(a == b)

//    println('a' + 10L)  //error
    println(10L + 'a')
//    println(10 + 'a')   //error
    println('a' + 10)

//    println(10 - 'a') //error
    println('a' - 10)
    println('a' - 'b')

    var c = 'a'
//    val c1 = 'a'++    //error
    val d = c++
    val e = ++c
    println(d)
    println(e)

    println(123 xor 22)
}

operator fun Long.plus(c: Char): Long {
    return this + c.toLong()
}