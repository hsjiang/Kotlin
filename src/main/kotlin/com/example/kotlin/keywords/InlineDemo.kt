package com.example.kotlin.keywords


//有时候，业务逻辑需要围绕某种类型创建包装器。然而，由于额外的堆内存分配问题，
// 它会引入运行时的性能开销。此外，如果被包装的类型是原生类型，性能的损失是很糟糕的，
// 因为原生类型通常在运行时就进行了大量优化，然而他们的包装器却没有得到任何特殊的处理


fun main() {
    // 不存在 'Inline1Class' 类的真实实例对象
    // 在运行时，'inline1Class' 仅仅包含 'Info'
    val info = Info("哈哈", 2)//@Info562
    val inline1Class = Inline1Class(info)//@Info562
}

//内联类必须含有唯一的一个属性在主构造函数中初始化。在运行时，将使用这个唯一属性来表示内联类的实例
//内联类可以声明属性与函数
inline class Inline1Class(val info: Info) {

    //内联类不能含有 init 代码块
    //inline class cannot have an initializer block
//    init {
//
//    }

    //内联类只能含有简单的计算属性（不能含有延迟初始化/委托属性）
    //inline class cannot have delegated properties
//    val string by lazy { String("haha") }


    //内联类不能含有幕后字段
//    lateinit var i: Int
//    var length1: Int
//        get() = info.info.length
//        set(value) {
//            field = if (value > 5) 5 else value
//        }
//
//    val size1: Int = info.info.length

    val length: Int
        get() = 1

    var size: Int
        get() = 1
        set(value) {}

    fun foo() {
        println("I'm Inline1Class's foo")
    }
}

data class Info(val info: String, val count: Int)


//继承
//
//内联类允许去继承接口
//禁止内联类参与到类的继承关系结构中。这就意味着内联类不能继承其他的类而且必须是 final


//表示方式
//
//在生成的代码中，Kotlin 编译器为每个内联类保留一个包装器
//为了生成性能最优的代码，Kotlin 编译更倾向于使用基础类型而不是包装器。
// 然而，有时候使用包装器是必要的。一般来说，只要将内联类用作另一种类型，它们就会被装箱
interface I

inline class Foo(val i: Int) : I

fun asInline(f: Foo) {}
fun <T> asGeneric(x: T) {}
fun asInterface(i: I) {}
fun asNullable(i: Foo?) {}

fun <T> id(x: T): T = x

fun test() {
    val f = Foo(42)

    asInline(f)    // 拆箱操作: 用作 Foo 本身
    asGeneric(f)   // 装箱操作: 用作泛型类型 T
    asInterface(f) // 装箱操作: 用作类型 I
    asNullable(f)  // 装箱操作: 用作不同于 Foo 的可空类型 Foo?

    // 在下面这里例子中，'f' 首先会被装箱（当它作为参数传递给 'id' 函数时）然后又被拆箱（当它从'id'函数中被返回时）
    // 最后， 'c' 中就包含了被拆箱后的内部表达(也就是 '42')， 和 'f' 一样
    val c = id(f)
}

//内联类与类型别名
//
//初看起来，内联类似乎与类型别名非常相似。实际上，两者似乎都引入了一种新的类型，并且都在运行时表示为基础类型。
//然而，关键的区别在于类型别名与其基础类型(以及具有相同基础类型的其他类型别名)是 赋值兼容 的，而内联类却不是这样。
//换句话说，内联类引入了一个真实的新类型，与类型别名正好相反，类型别名仅仅是为现有的类型取了个新的替代名称(别名)
typealias NameTypeAlias = String

inline class NameInlineClass(val s: String)

fun acceptString(s: String) {}
fun acceptNameTypeAlias(n: NameTypeAlias) {}
fun acceptNameInlineClass(p: NameInlineClass) {}

fun testTypeAliasAndInline() {
    val nameAlias: NameTypeAlias = ""
    val nameInlineClass: NameInlineClass = NameInlineClass("")
    val string: String = ""

    acceptString(nameAlias) // 正确: 传递别名类型的实参替代函数中基础类型的形参
//    acceptString(nameInlineClass) // 错误: 不能传递内联类的实参替代函数中基础类型的形参

    // And vice versa:
    acceptNameTypeAlias(string) // 正确: 传递基础类型的实参替代函数中别名类型的形参
//    acceptNameInlineClass(string) // 错误: 不能传递基础类型的实参替代函数中内联类类型的形参
}

