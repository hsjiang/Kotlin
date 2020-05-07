package com.example.kotlin.chapter1

fun main() {
    doubleCompare()
}

fun biaoshifangshi() {
    val a: Int = 1000
    val b: Int = 1000

    println(a == b)
    println(a === b)

    val c: Int? = 1000
    val d: Int? = 1000

    println(a == c)
    println(a === c)

    println(c == d)
    println(c === d)

    val e: Int? = a
    val f: Int? = a
    println(e == f)
    println(e === f)
}

fun autoBox() {
    val a: Int? = 1 // 一个装箱的 Int, 字面值是静态检测的
    //val b: Long? = a // error,较小的类型不能隐式转换为较大的类型
    val b: Long? = a?.toLong() // ok,显示转换
}

fun doubleCompare() {
    println("${-0.0 == 0.0}")
    println("${-0 == 0}")
}