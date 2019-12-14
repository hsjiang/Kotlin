package com.example.kotlin.chapter6

import java.util.*

//协变（covariant）与逆变（contravariant）
// Java: A是B的父类；如果有f<A>是f<B>的父类，那么f叫做协变；
// 如果有f<B>是f<A>的父类，那么f叫做逆变；
// 如果两种关系都不成立叫做不可变

//在java中数组是协变的，泛型不是协变的
//<? extends T>实现了泛型的协变
//<? super T>实现了泛型的逆变

//PECS: producer-extends, consumer-super

//在Kotlin中，我们把那些只能保证读取数据时类型安全的对象叫做生产者，用 out T标记；
// 把那些只能保证写入数据安全时类型安全的对象叫做消费者，用 in T标记。
//out T 等价于? extends T in T 等价于 ? super T 此外, 还有 * 等价于?

fun main(args: Array<String>) {
    Collections.copy(arrayListOf<CharSequence>(), arrayListOf<String>())

    copy(arrayOf<C>(), arrayOf<A>())

    //类型投影，我们只可以调用返回类型为类型参数 T 的方法
    val array: Array<out String> = arrayOf("", "")
//    array.set(1,"")
    array[1]

    val i: Int
}

interface Source<out T> {
    fun nextT(): T
    //type parameter T is declared as 'out' but occurs in 'in' position int type T
//    fun addT(t:T)
}

interface Products<in T> {
    //type parameter T is declared as 'out' but occurs in 'in' position int type T
//    fun nextT(): T

    fun addT(t: T)
}

fun demo1(str: Source<String>) {
    val obj: Source<CharSequence> = str
}

//类型投影(type projection)。其主要作用是参数作限定，避免不安全操作
fun copy(from: Array<out B>, to: Array<in B>) {

}

open class A

open class B : A()

class C : B()

//星投影
//如果类型被声明为 interface Function <in T, out U>，我们有以下星投影：
//
//Function<*, String> 表示 Function<in Nothing, String>；
//Function<Int, *> 表示 Function<Int, out Any?>；
//Function<*, *> 表示 Function<in Nothing, out Any?>。
//*投影跟 Java 的原始类型类似，不过是安全的

//泛型约束
//能够替换给定类型参数的所有可能类型的集合可以由泛型约束限制

//冒号之后指定的类型是上界：只有 Comparable<T> 的子类型可以替代 T
fun <T : Comparable<T>> sort() {

}

//默认的上界（如果没有声明）是 Any?。在尖括号中只能指定一个上界。
// 如果同一类型参数需要多个上界，我们需要一个单独的 where-子句
fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String> where T : CharSequence, T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}