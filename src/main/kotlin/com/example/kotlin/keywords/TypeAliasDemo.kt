package com.example.kotlin.keywords

//类型别名为现有类型提供替代名称。 如果类型名称太长，你可以另外引入较短的名称，并使用新的名称替代原类型名
//类型别名不会引入新类型
fun main() {

    val nested = ANested()
    nested.foo()

    predicateInt()

}

class A {
    class NestedClass {
        fun foo() {
            println("I'm nested class")
        }
    }
}

typealias ANested = A.NestedClass

typealias Predicate<T> = (T) -> Boolean

fun predicateInt() {
    val f: (Int) -> Boolean = { it > 1 }
    println(foo(f))
}

fun foo(p: Predicate<Int>) = p(1)