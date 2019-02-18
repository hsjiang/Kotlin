package com.example.kotlin.chapter7

import java.util.*

fun main(args: Array<String>) {
    println("${User.userName} ${User.password}")

    println(NestedObject.InnerObject.name)

//    println(XY.x)

//    publicFoo(1).value
    privateFoo().value

    println(Factory.print())
    println(Factory.Companion.print())
}

object User {
    val userName: String = "admin"
    val password: String = "123"

    fun user(): String {
        return ""
    }
}

// 嵌套（Nested）object对象
class NestedObject {

    object InnerObject {
        val name: String = "hhhh"
    }
}

//匿名object
//匿名对象只可以用在本地和私有作用域中声明的类型
val XY = object {
    var x = 0.0f
    var y = 0.0f
}

// 私有函数，返回的是匿名object类型
private fun privateFoo() = object {
    val value = 1
}

// 公有函数，返回的类型是 Any
fun publicFoo(x: Int) = object {
    val value = 1 + x
    fun sum(): Int {
        return x + value
    }
}

//匿名局部object
fun anonymousObject(arg1: Int, arg2: Int): Int {
    val ano = object {
        var x = 1
        var y = 2
    }
    return arg1 * ano.x + arg2 * ano.y
}

fun compare() {
    Collections.sort(mutableListOf(1, 2, 3, 4), object : Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o1.compareTo(o2)
        }
    })
}


//伴生对象，一个类只能有一个伴生对象
class Factory {
    companion object {
        fun print() {
            print("im factory's companion object")
        }
    }
}

