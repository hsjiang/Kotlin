package com.example.kotlin.chapter3

//属性扩展
val <T> List<T>.lastIndex: Int get() = size - 1


//函数扩展
fun String.notEmpty(): Boolean {
    return !this.isEmpty()
}

