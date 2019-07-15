package com.example.kotlin.chapter1

import com.example.kotlin.chapter3.User

fun main(args: Array<String>) {
    val fileds = Fields(1)
    fileds.setEmpty()

    fileds.setBackField(10)
}

class Fields(var gender: Int) {
    lateinit var bar: String

    var name = ""
        set(value) {
            field = if (gender == 1) "mr.$value" else "ms.$value"
        }

    var backingFiled = 5
        get() = field * 5
        set(value) {
            field = value * 2
        }

    //幕后属性
    var size = 5
    //isEmpty没有幕后字段(没有默认访问器，并且没有field)
    var isEmpty //initializer is not allowed here because this property has no backing filed
        get() = size == 0
        set(value) {
            size = if (value) 0 else size
        }

    fun setEmpty() {
        println(isEmpty)
        println(size)
        isEmpty = true
        println(size)
    }

    fun setBackField(value:Int){
        println(backingFiled)
        backingFiled = 10
        println(backingFiled)
    }
}
