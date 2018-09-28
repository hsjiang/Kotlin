package com.example.kotlin.chapter8

fun main(args: Array<String>) {
    var defaultParamBase = DefaultParamBase()
    defaultParamBase.add(1)

    var defaultParam = DefaultParam()
    defaultParam.add(y = 1)

    namedParamsFun("jack", "男", age = 1, number = "123", address = "")
}

fun fpDefault(x: Int = 0, y: Int = 1): Int {
    return x + y
}

open class DefaultParamBase {
    open fun add(x: Int = 0, y: Int = 0): Int {
        return x + y
    }
}

class DefaultParam : DefaultParamBase() {
    override fun add(x: Int, y: Int): Int { // 不能有默认值
        return x + y
    }
}

fun namedParamsFun(name: String, gender: String, age: Int = 0, number: String = "110", address: String) {

}