package com.example.kotlin.chapter5

import com.example.java.chapter5.VarargDemo

fun main(args: Array<String>) {

    val demo = VarargDemo<Any?>()

    val array = arrayOf(0, 1, 2, 3)
    val arrayList = arrayListOf(0, 1, 2, 3)
//    val result = demo.append(array)//[Ljava.lang.Integer;@76ed5528
    val resultList = demo.append(arrayList)//[0, 1, 2, 3]
    val result = demo.append(*array)//0123
    println(resultList)
    println(result)


//    val result2 = append(array)//[Ljava.lang.Integer;@3f99bd52
    val resultList2 = append(arrayList)//[0, 1, 2, 3]
    val result2 = append(*array)//0123
    println(resultList2)
    println(result2)

    println(array.javaClass)
    println(array::class.java)
}

fun <T> append(vararg element: T): String {
    val builder = StringBuilder()
    for (t in element) {
        builder.append(t)
    }
    return builder.toString()
}