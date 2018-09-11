package com.example.kotlin.chapter3

//kotlin中任何表达式都可以用标签来标记  标识符+@
//kotlin的函数是可以被嵌套的，它有函数字面常量、局部函数等

fun main(array: Array<String>) {
    labelDemo1()

    println()
    labelDemo2()


    println()
    labelDemo3()
}

fun labelDemo1() {
    println(" START " + ::labelDemo1.name)
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    intArray.forEach here@{
        if (it == 3) return@here
        println(it)
    }
    println(" END " + ::labelDemo1.name)
}

//隐式标签
fun labelDemo2() {
    println(" START " + ::labelDemo2.name)
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    intArray.forEach {
        if (it == 3) return@forEach
        println(it)
    }
    println(" END " + ::labelDemo2.name)
}

fun labelDemo3() {
    outer@ for (outer in 1..5) {
        println("outer : $outer")
        inner@ for (inner in 1..10) {
            println("inner : $inner")
            if (inner % 2 == 0) break@inner
        }
    }
}