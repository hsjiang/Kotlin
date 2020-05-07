package com.example.kotlin.chapter1

data class User(val name: String, val age: Int)

fun main(args: Array<String>) {
    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)

    val jane = User("Jane", 35)
    val (name, age) = jane//结构声明
    println("$name, $age years of age")
}