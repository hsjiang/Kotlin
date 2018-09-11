package com.example.kotlin.chapter3

fun main(args: Array<String>) {
    var x = 10
    while (x > 0) {
        x--
        print("$x ")
    }

    println()

    var y = 0
    do {
        print("$y ")
        y++
    } while (y < 10)
}