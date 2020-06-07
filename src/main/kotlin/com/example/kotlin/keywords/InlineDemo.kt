package com.example.kotlin.keywords

//有时候，业务逻辑需要围绕某种类型创建包装器。然而，由于额外的堆内存分配问题，
// 它会引入运行时的性能开销。此外，如果被包装的类型是原生类型，性能的损失是很糟糕的，
// 因为原生类型通常在运行时就进行了大量优化，然而他们的包装器却没有得到任何特殊的处理
fun main() {

}

//内联类必须含有唯一的一个属性在主构造函数中初始化。在运行时，将使用这个唯一属性来表示内联类的实例
inline class Inline1Class(val str: String) {

}