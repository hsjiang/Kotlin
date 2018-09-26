package com.example.kotlin.chapter7

//构造函数和初始化块
//属性
//函数
//嵌套类和内部类
//对象声明

class World constructor(var arg1: String) {
    var name: String = arg1

    init {
        arg1 = "arg1"
        println(arg1)
    }

    constructor(arg1: String, arg2: Int) : this(arg1) {
        this.name = arg1
    }
}