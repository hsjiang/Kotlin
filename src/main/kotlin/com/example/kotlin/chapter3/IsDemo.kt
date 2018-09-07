package com.example.kotlin.chapter3

fun getLength(obj: Any): Int? {
    var result = 0
    if (obj is String) {
        println(obj::class)
        result = obj.length
        println(result)
    }

    if (obj is Int) {
        println(obj::class)
        result = obj
        println(result)
    }

    println(obj::class)
    return result
}