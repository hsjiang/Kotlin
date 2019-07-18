package com.example.kotlin.chapter1

//所有子类都必须在与密封类自身相同的文件中声明
//一个密封类是自身抽象的，它不能直接实例化并可以有抽象成员
//扩展密封类子类的类（间接继承者）可以放在任何位置，而无需在同一个文件中
sealed class Expr

data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

fun main(args: Array<String>) {


}

fun eval(expr: Expr): Double = when(expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
    // 不再需要 `else` 子句，因为我们已经覆盖了所有的情况
}