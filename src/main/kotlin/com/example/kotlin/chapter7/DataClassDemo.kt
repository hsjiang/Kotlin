package com.example.kotlin.chapter7

fun main(args: Array<String>) {
    val user = UserInfo("jack", "男", 18)
    println(user.name)
    println(user.component1())
    println(user.toString())

    println(user.copy(name = "josh").toString())

    println(pair.toList())
    println(triple.toList())
}

//1.主构造函数需要至少有一个参数
//2.主构造函数的所有参数需要标记为 val 或 var
//3.数据类不能是抽象、开放、密封或者内部的（abstract,open,sealed,inner）,数据类只能是final
data class UserInfo(var name: String, var gender: String, var age: Int) {
    fun validate(): Boolean {
        return true
    }
}

// 标准数据类二元组Pair 和三元组Triple
var pair = Pair("first", "second")
var triple = Triple("first", "second", "third");