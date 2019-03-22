package com.example.kotlin.chapter3

fun main(args: Array<String>) {
    val a = 10
    println("${+a} ${a.unaryPlus()}")

    println()

    val p = Point(1, 1)
    val np = -p
    println(np)


    val c = Counter(1)
    val cplus = c + 10
    println(cplus)

    val c1 = Counter(10)
    val cminus = c1 / 2
    println(cminus)

    val p1 = Point(1, 1)
    val p2 = Point(1, 1)
    println(p1 === p2)
    println(p1.equals(p2))
    println(p1 == p2)

    val s1: String = "abc"
    val s2: String = "abc"
    println(s1 === s2)
    println(s1 == s2)

    val s3: String? = null
    println(s3 ?: "is null")
}

class OperatorDemo {

}

data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

data class Counter(var index: Int) {
    operator fun plus(increment: Int): Int {
        return index + increment
    }
}

//operator fun Counter.plus(increment: Int): Counter {
//    return Counter(index + increment)
//}

operator fun Counter.div(increment: Int): Counter {
    return Counter(index / increment)
}


