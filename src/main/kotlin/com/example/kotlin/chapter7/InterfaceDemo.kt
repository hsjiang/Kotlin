package com.example.kotlin.chapter7

fun main(args: Array<String>) {
    var impl = ProjectImpl()
    impl.print("haha")
    println(impl.owner)
}

interface Project {
    val name: String
    //    val owner: String = ""
    val owner: String get() = "owner is me"

    fun save(str: String)

    fun print(str: String) {
        println("Project $str")
    }
}

interface Milestone {
    val name: String

//    fun print(str: String) {
//        println("Milestone $str")
//    }
}

class ProjectImpl : Project, Milestone {

    override val name: String
        get() = "impl"

    override fun save(str: String) {

    }

//    override fun print(str: String) {
//        super<Milestone>.print(str)
//        super<Project>.print(str)
//        println("ProjectImpl $str")
//    }
}