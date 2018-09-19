package com.example.kotlin.chapter3

open class Father {
    open val firstName = "james"
    open val lastName = "die"
}

open class Son : Father() {
    override val lastName = "er"

    fun love() {
        println(super.firstName + " " + super.lastName + " Love " + this.firstName + " " + this.lastName)
    }
}