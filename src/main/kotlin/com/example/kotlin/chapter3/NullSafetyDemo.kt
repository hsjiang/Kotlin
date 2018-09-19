package com.example.kotlin.chapter3

fun main(args: Array<String>) {

    var a: String? = "abc"
    a = null
    println(a?.length)
//    println(a!!.length)

    val listWithNulls: List<String?> = listOf("A", "B", null)
    listWithNulls.forEach {
        println(it)
        //只对非空值执行某个操作
        it?.let {
            println("let: $it")
        }
    }
}