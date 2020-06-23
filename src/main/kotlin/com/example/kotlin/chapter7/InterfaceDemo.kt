package com.example.kotlin.chapter7

fun main(args: Array<String>) {
    var impl = ProjectImpl()
    impl.print("haha")
    println(impl.owner)
}

interface Project {
    val name: String
    //    val owner: String = ""
    val owner: String
        get() = "owner is me"

    fun save(str: String)

    fun print(str: String) {
        println("Project $str")
    }
}

interface Milestone {
    val name: String//不能有初始化器，不能有幕后字段

    var stone: String
        //不能有初始化器，不能有幕后字段
        get() = ""
        set(value) {}

    fun print(str: String) {
        println("Milestone $str")
    }
}

interface MilestoneImpl : Milestone {
    override var stone //不能有初始化器，不能有幕后字段
        get() = "MilestoneImpl"
        set(value) {}
}

class ProjectImpl : Project, MilestoneImpl {

    override val name: String
        get() = "impl"

    override fun save(str: String) {

    }

    override fun print(str: String) {
        //Many subtypes available,please specify the one you mean in angle brackets,e.g. 'super.<Foo>'
//        super.print(str)

        super<MilestoneImpl>.print(str)
        super<Project>.print(str)
        println("ProjectImpl $str")
    }
}
