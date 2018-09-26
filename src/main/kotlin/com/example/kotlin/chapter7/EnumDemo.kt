package com.example.kotlin.chapter7

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
    },

    onStart {
        override fun signal() = onStop
    },

    onStop {
        override fun signal() = onStart
    },

    onDestroy {
        override fun signal() = onDestroy
    };

    abstract fun signal(): ActivityLifeState
}