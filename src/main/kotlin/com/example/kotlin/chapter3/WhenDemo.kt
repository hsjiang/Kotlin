package com.example.kotlin.chapter3

fun cases(obj: Any) {
    when (obj) {
        1 -> {
            println("is Int")
            println("第一项")
        }
        2, 3 -> println("第二项或第三项")
        !in 4..10-> println("!in 4..10")
        "hello" -> println("is hello")
        is String -> println("is String")
        is Long -> println("is Long")
        else -> {
            println("default: " + obj.toString())
        }
    }
}