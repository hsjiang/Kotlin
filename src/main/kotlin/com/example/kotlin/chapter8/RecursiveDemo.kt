package com.example.kotlin.chapter8

fun main(args: Array<String>) {

}

//阶乘
fun factorial(x: Int): Int {
    if (x == 0) return 1
    return x * factorial(x - 1)
}

//斐波那契
fun fibonacci(x: Int): Int {
    if (x == 1 || x == 2) return 1
    return fibonacci(x - 1) + fibonacci(x - 2)
}