package com.example.kotlin.chapter7

//在某种意义上，sealed类是枚举类的扩展：枚举类型的值集合也是受限的，
// 但每个枚举常量只存在一个实例，而密封类的一个子类可以有可包含状态的多个实例

//虽然密封类也可以有子类，但是所有子类都必须在与密封类自身相同的文件中声明。
//扩展密封类子类的类（间接继承者）可以放在任何位置，而无需在同一个文件中

sealed class Expression

class Unit : Expression()
data class Const(val number: Double) : Expression()
data class Sum(val e1: Expression, val e2: Expression) : Expression()
data class Multiply(val e1: Expression, val e2: Expression) : Expression()
object NaN : Expression()

//使用密封类的好处
fun eval(expr: Expression): Double = when (expr) {
    is Unit -> 1.0
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    is Multiply -> eval(expr.e1) * eval(expr.e2)
    NaN -> Double.NaN
// 不再需要 `else` 子句，因为我们已经覆盖了所有的情况
}