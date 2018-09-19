package com.example.kotlin.chapter3

fun main(array: Array<String>) {
    val max = maxReturn(15, 10)
    println("max: $max " + max::class)

    sum(1, 1)

    val sumf = sumfReturn(5, 10).invoke()
    println("sumf: $sumf " + sumf::class)

    println(sumfReturn(1, 2))

    println()

    returnDemo1()
    returnDemo2()
}

fun sumReturn(a: Int, b: Int) = a + b

//匿名函数
val sum = fun(a: Int, b: Int) = a + b

fun maxReturn(a: Int, b: Int) = if (a > b) a else "b 大"

fun sumfReturn(a: Int, b: Int) = { a + b }

fun returnDemo1() {
    println(" START " + ::returnDemo1.name)
    val intArray = intArrayOf(1, 2, 3, 4)
    intArray.forEach {
        if (it == 3) return //return@forEach
        println(it)
    }
    println(" END " + ::returnDemo1.name)
}

fun returnDemo2() {
    println(" START " + ::returnDemo2.name)
    val intArray = intArrayOf(1, 2, 3, 4)
    intArray.forEach(fun(a: Int) {
        if (a == 3) return
        println(a)
    })
    println(" END " + ::returnDemo2.name)
}