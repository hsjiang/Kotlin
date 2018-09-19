package com.example.kotlin.chapter4

fun main(args: Array<String>) {
    println(goo as Foo)
}

open class Foo
class Goo : Foo()

val foo = Foo()
val goo = Goo()