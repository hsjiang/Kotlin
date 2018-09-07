package com.example.kotlin.chapter3


fun main(args: Array<String>) {
    declareVar()
    declareVal()

//    var impl = DeclareValImpl(2)
//    impl.print()
//
//    var impl2 = DeclareValImpl2()
//    impl2.print()
}

fun declareVar() {
//    var c
    var b: Int
    b = 2

    var a = 1
    a += 2
    println(a)
    println(a::class)
    println(a::class.java)
}

fun declareVal() {
    val a = "sssss"
    println(a)
    println(a::class)
    println(a::class.java)

    val c: Int
    c = 1
//    val b
    val b = "s"

    println(c)
}

//abstract class DeclareVal {
//    //    val c: Int
//    //    val b
//    abstract val c: Int
//}
//
//class DeclareValImpl(override val c: Int) : DeclareVal() {
//
//    fun print() {
//        println(c)
//    }
//}
//
//class DeclareValImpl2 : DeclareVal() {
//    override val c: Int = 3
//    //or  override val c: Int get() = 1
//
//    fun print() {
//        println(c)
//    }
//
//}
