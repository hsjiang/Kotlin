package com.example.kotlin.chapter4


fun main(args: Array<String>) {
    val originS = """  abc
        ...|def"""

    println(originS)
    println(originS.trimMargin("...|"))
    println(originS.trimIndent())

    val s = "abcdef"

    println(s[2])

    for (c in s) {
        print("$c ")
    }

    println()

    println(s + 10L)
    println(s + 1.20f)
    println(s + null)

    val str: String = "aabbccddee"
    str.forEach { print("$it ") }
}