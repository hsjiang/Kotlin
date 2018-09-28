package com.example.kotlin.chapter8

import javax.swing.tree.TreeNode

fun main(args: Array<String>) {

}

//局部函数
fun sum(x: Int, y: Int, z: Int): Int {
    val delta = 0;
    fun add(a: Int, b: Int): Int {
        return a + b + delta
    }
    return add(x, add(y, z))
}

//成员函数
class MemberFunction {
    fun foo() {}
}

//匿名函数
var sum = fun(x: Int, y: Int) = x + y

//内联函数，具体化的类型参数
inline fun <reified T> TreeNode.findParentOfType(): T? {
    var p = this.parent
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T?
}

//尾递归
tailrec fun findFixPoint(x: Double = 1.0): Double =
        if (x == Math.cos(x)) x else findFixPoint(Math.cos(x)) // 函数必须将其自身调用作为它执行的最后一个操作