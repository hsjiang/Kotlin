package com.example.kotlin.chapter7

fun main(args: Array<String>) {

}

class NestedClassDemo {
    class NestedClass {

    }

    inner class InnerNestedClass {

    }

    fun doRun() {
        Thread {
            println("run")
        }.start()

        Thread(object : Runnable {
            override fun run() {
                println("run")
            }
        }).start()
    }
}