package com.example.kotlin.chapter7

fun main(args: Array<String>) {
    var impl = Impl("me")
    impl.addr = "1aa"
    println(impl.addr)

}

abstract class AbstractClass {
    abstract var name: String
    abstract val age: Int
    abstract var addr: String

    abstract fun doEat()
    abstract fun doWalk()

    fun doSwim() {
        println("I am Swimming ... ")
    }

    open fun doSleep() {
        println("I am sleeping ... ")
    }
}

open class Impl(override var name: String) : AbstractClass() {
    override val age: Int get() = 1
    override var addr: String
        get() = "address"
        set(value) {
            value + 1
        }

    override fun doEat() {

    }

    override fun doWalk() {

    }

    override fun doSleep() {

    }
}