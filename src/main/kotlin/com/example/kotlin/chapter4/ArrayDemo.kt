package com.example.kotlin.chapter4

fun main(args: Array<String>) {
    val array = arrayOf("a", "b", "c", "d", "e")
    for (i in array) {
        print("$i ")
    }

    println()
    val arrayNull = arrayOfNulls<Int>(5)
    arrayNull.forEach {
        print("$it ")
    }

    println()
    val plus = Array(10) { i -> i + i }
    for (p in plus) {
        print("$p ")
    }

    //和 Array 并没有继承关系，但它们有同样的函数和属性集
    val intArray = intArrayOf(11, 22, 33, 44, 55)
}