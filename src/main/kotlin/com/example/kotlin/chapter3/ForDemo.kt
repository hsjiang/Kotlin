package com.example.kotlin.chapter3

val array = arrayOf("1", "2", "3", "4")

fun main(args: Array<String>) {
    for (s in array) {
        print("$s ")
    }

    println()
    for (index in array.indices) {
        print("$index ")
    }

    println()
    for ((index, value) in array.withIndex()) {
        print("$index: $value  ")
    }
}

fun forIndices() {
    val array = arrayOf(1, 2, 3, 4)
    for (i in array.indices) {
        print("${array[i]},")
    }
}
