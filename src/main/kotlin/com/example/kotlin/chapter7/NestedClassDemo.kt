package com.example.kotlin.chapter7

import com.example.kotlin.chapter3.foo

fun main(args: Array<String>) {
    NestedClassDemo.NestedClass().foo()
    NestedClassDemo().InnerNestedClass().foo()

    val anonymousInnerClass = object : NestedClassDemo() {
        fun foo(): Int {
            doRun()
            return filed1
        }
    }
    anonymousInnerClass.filed1
    anonymousInnerClass.outerFoo()
    anonymousInnerClass.foo()
}

fun outerFoo() {}
fun outerFoo2() {}
fun outerFoo3() {}

class AnonymousTest() {
    val filed1 = 2
    val filed2 = 2

    fun test() {
        val anonymousInnerClass = object : NestedClassDemo() {
            fun anonymousFoo(): Int {
                outerFoo3()
                outerFoo2()
                outerFoo()
                foo2()
                filed2
                return filed1
            }
        }
    }

    fun outerFoo2() {

    }

    fun outerFoo() {

    }

    fun foo2() {

    }
}

open class NestedClassDemo {
    val filed1 = 1

    fun outerFoo() {

    }

    class NestedClass {
        fun foo() {
//            filed1 //cannot do this
        }
    }

    inner class InnerNestedClass {
        fun foo(): Int {
            doRun()
            return filed1
        }
    }

    fun doRun() {
        run {
            println("run")
            ""
        }.length

        {
            println("run")
            ""
        }.invoke().length

        Thread {
            println("run")
        }.start()

        Thread(Runnable { println("run") }).start()
    }
}