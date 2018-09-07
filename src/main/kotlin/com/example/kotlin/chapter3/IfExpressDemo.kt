package com.example.kotlin.chapter3

//最后的表达式表示该块的值
fun max(a: Int, b: Int): Int {
    val max = if (a > b) {
        println(a)
        a + 1
    } else {
        println(b)
        b
    }
    return max
}

fun max2(a: Int, b: Int) {
    var max = 0
    if (a > b) {
        if (a > 20) {
            max = 1
        }
    } else {
        max = 2
    }
    println(max)
}