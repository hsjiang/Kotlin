package com.example.kotlin.chapter9

import kotlinx.coroutines.asContextElement

fun main(){
    val threadLocal = ThreadLocal<String>().apply { set("Init") }
    threadLocal.asContextElement()
}
