package com.example.kotlin.chapter3

class ThisDemo {
    val thisis = "THIS IS"

    fun whatIsThis(): ThisDemo {
        println(this.thisis)
        this.howIsThis()
        return this
    }

    fun howIsThis() {
        println("HOW IS THIS ?")
    }


    val sum = fun Int.(a: Int): Int = this + a
    fun sum(): Int {
        return 5.sum(2)
    }

    val concat = fun String.(s: Int): String = this + s
    fun concat(): String {
        return "abc".concat(123)
    }
}