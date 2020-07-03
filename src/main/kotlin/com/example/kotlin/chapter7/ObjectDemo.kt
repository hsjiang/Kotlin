package com.example.kotlin.chapter7

import java.util.*

//对象表达式与对象声明

//对象表达式和对象声明之间有一个重要的语义差别：
//
//1.对象表达式是在使用他们的地方立即执行（及初始化）的；
//2.对象声明是在第一次被访问到时延迟初始化的；
//3.伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配

fun main(args: Array<String>) {
    println("${User.userName} ${User.password}")

    println(NestedObject.InnerObject.name)

//    println(XY.x)

//    publicFoo(1).value
    privateFoo().value

    println(Factory.print())
    println(Factory.Companion.print())
}

//对象声明
object User : NestedObject() {
    val id: Int

    val userName: String = "admin"
    val password: String = "123"

    //对象声明的初始化过程是线程安全的并且在首次访问时进行
    init {
        id = 5
    }

    fun user(): String {
        return ""
    }

    //可以嵌套到对象声明中
    object Address {

    }
}

// 嵌套（Nested）object对象
open class NestedObject {

    object InnerObject {
        val name: String = "hhhh"
    }

    //可以嵌套到非内部类中
    class NestedClass1 {
        val i = objectInNestedClass1.x

        object objectInNestedClass1 {
            val x = 1
        }
    }

    inner class InnerClass1 {
        //object is not allowed here
//        object objectInInnerClass1 {
//            val x = 1
//        }
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
            print("im factory1's companion object")
        }
    }
}

open class Factory2 {
    companion object F2 {
        fun print() {
            print("im factory2's companion object")
        }
    }

    open fun funOfFactory2() {

    }
}

//即使伴生对象的成员看起来像其他语言的静态成员，在运行时他们仍然是真实对象的实例成员，而且，例如还可以实现接口
//使用 @JvmStatic 注解，你可以将伴生对象的成员生成为真正的静态方法和字段
class Factory3 {
    companion object : Factory2() {
        override fun funOfFactory2() {

        }
    }
}

fun companionInvoke() {
    //其自身所用的类的名称（不是另一个名称的限定符）可用作对该类的伴生对象 （无论是否具名）的引用
    val factory = Factory
    val companion1 = Factory.Companion
//    val companion2 = Factory2.Companion
    val factory2 = Factory2
    val companion2 = Factory2.F2

    fun invokeCompanion() {
        factory.print()
        companion1.print()
        Factory.print()

        factory2.print()
        companion2.print()
        Factory2.print()

    }

    val f22: Factory2 = Factory3
    f22.funOfFactory2()
}

