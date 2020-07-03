package com.example.kotlin.chapter8

fun main(){

}

//let
//1.可用于在调用链的结果上调用一个或多个函数
//numbers.map { it.length }.filter { it > 3 }.let {
//    println(it)
//    // 如果需要可以调用更多函数
//}
//
//2.let 经常用于仅使用非空值执行代码块
//
//3.使用 let 的另一种情况是引入作用域受限的局部变量以提高代码的可读性
//numbers.first().let { firstItem ->
//    println("The first item of the list is '$firstItem'")
//    if (firstItem.length >= 5) firstItem else "!" + firstItem + "!"
//}


//with:对于这个对象，执行以下操作
//

//run
//run 和 with 做同样的事情，但是调用方式和 let 一样——作为上下文对象的扩展函数
//
//1.当 lambda 表达式同时包含对象初始化和返回值的计算时
// val result = service.run {
//    port = 8080
//    query(prepareRequest() + " to port $port")
//}
//
//2.除了在接收者对象上调用 run 之外，还可以将其用作非扩展函数
//val hexNumberRegex = run {
//    val digits = "0-9"
//    val hexDigits = "A-Fa-f"
//    val sign = "+-"
//
//    Regex("[$sign]?[$digits$hexDigits]+")
//}
//
//for (match in hexNumberRegex.findAll("+1234 -FFFF not-a-number")) {
//    println(match.value)
//}

//apply:将以下赋值操作应用于对象
//

//also:并且用该对象执行以下操作
//
//also 对于执行一些将上下文对象作为参数的操作很有用。
// 对于需要引用对象而不是其属性与函数的操作，
// 或者不想屏蔽来自外部作用域的 this 引用时
//


//以下是根据预期目的选择作用域函数的简短指南：
//
//对一个非空（non-null）对象执行 lambda 表达式：let
//将表达式作为变量引入为局部作用域中：let
//对象配置：apply
//对象配置并且计算结果：run
//在需要表达式的地方运行语句：非扩展的 run
//附加效果：also
//一个对象的一组函数调用：with


//尽管作用域函数是使代码更简洁的一种方法，但请避免过度使用它们：
// 这会降低代码的可读性并可能导致错误。避免嵌套作用域函数，
// 同时链式调用它们时要小心：此时很容易对当前上下文对象及 this 或 it 的值感到困惑。

