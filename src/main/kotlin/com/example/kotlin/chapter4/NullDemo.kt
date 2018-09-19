package com.example.kotlin.chapter4

fun main(args: Array<String>) {
    println(null == null)
    println(null != null)
    println(null is Any)
    println(null is Any?)

    var a = null
    println(a)

    println(getLength(null))
}

fun getLength(str: String?): Int? {
    return str?.length
}