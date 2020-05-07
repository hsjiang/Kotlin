package com.example.kotlin.chapter3

import java.util.*

fun main(args: Array<String>) {
    printFoo(D())//c

    MyClass.foo()
}

//===================属性扩展=======================
//由于扩展没有实际的将成员插入类中，因此对扩展属性来说幕后字段是无效的。
// 这就是为什么扩展属性不能有初始化器。
// 他们的行为只能由显式提供的 getters/setters 定义
val <T> List<T>.lastIndex: Int get() = size - 1


//===================函数扩展=======================
fun String.notEmpty(): Boolean {
    return !this.isEmpty()
}

//fun <T : Comparable<T>> List<Comparable<T>>.swap(i: Int, key: T) {
//    Collections.swap(this, i, key)
//}
//
//fun <T : Comparable<T>> List<Comparable<T>>.binarySearch(max: T): Int {
//    return Collections.binarySearch(this, max)
//}
//
//fun <T : Comparable<T>> Collection<T>.max(): T {
//    return Collections.max(this)
//}

//===================simple1=======================//
open class C

class D : C()

fun C.foo() = "c"
fun D.foo() = "d"

fun printFoo(c: C) {
    println(c.foo())
}

//printFoo(D()) 输出c,调用的扩展函数是由函数调用所在的表达式的类型来决定的，
// 而不是由表达式运行时求值结果决定的

//=================================================//


//===================simple2=======================//

class E {
    fun foo() {
        println("member")
    }
}

fun E.foo() {// is never used,总是取成员函数
    println("extension")
}

//=================================================//

//===================simple3=======================//

//伴生对象的扩展
class MyClass {
    companion object {

    }
}

fun MyClass.Companion.foo() {// is never used,总是取成员函数
    println("companion's extension")
}

//MyClass.foo() "companion's extension"

//=================================================//


//===================simple4=======================//
class F {
    fun bar() {}
}

class G {
    fun baz() {

    }

    fun F.foo() {
        bar()   // 调用 F.bar
        baz()   // 调用 G.baz
    }

    fun F.goo() {
        toString()         //扩展接收者优先, 调用 D.toString()
        this@G.toString()  // 调用 C.toString()
    }

    fun caller(f: F) {
        f.foo()   // 调用扩展函数
    }
}
//G的实例分发接收者，F的实例拓展接收者
//=================================================//