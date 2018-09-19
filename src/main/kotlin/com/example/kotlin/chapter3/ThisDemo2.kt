package com.example.kotlin.chapter3

class ThisDemo2 {
    val oh = "oh"

    inner class Inner {
        fun m() {
            val outer = this@ThisDemo2
            val inner = this@Inner
            val pthis = this
            println("outer: $outer")
            println("outer: ${this@ThisDemo2}")
            println("inner: " + inner)
            println("this: $pthis")
            println(this@ThisDemo2.oh)

            val fun1 = hello@ fun String.() {
                val d1 = this
                println("fun1$d1")
            }

            val fun2 = { s: String ->
                val d2 = this
                println("d2=$d2  $s")
            }

            "abc".fun1()

            val arrays = arrayOf("111", "222")

            arrays.forEach(fun2)
        }
    }
}