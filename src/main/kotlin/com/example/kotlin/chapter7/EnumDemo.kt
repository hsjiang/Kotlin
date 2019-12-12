package com.example.kotlin.chapter7

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

fun main(args: Array<String>) {
    println(Color.RED.rgb)
    println(Color.RED.name)
    println(Color.RED.ordinal)

    println(ActivityLifeState.onCreate.signal())

    println(enumValues<Color>().asList())
}

enum class Color(var rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
}

//枚举常量也可以声明自己的匿名类
enum class ActivityLifeState {
    onCreate {
        override fun signal() = onCreate
        override fun str(): String = "onCreate"
    },

    onStart {
        override fun signal() = onStart
        override fun str(): String = "onStart"
    },

    onStop {
        override fun signal() = onStop
        override fun str(): String = "onStop"
    },

    onDestroy {
        override fun signal() = onDestroy

        override fun str(): String = "onDestroy"
    };

    abstract fun signal(): ActivityLifeState

    abstract fun str(): String
}

//枚举类可以实现接口
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}