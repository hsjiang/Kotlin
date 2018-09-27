package com.example.kotlin.chapter7

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val subject = RealSubject("world")
    subject.hello()

    val proxySubject = ProxySubject(subject)
    proxySubject.hello()

    println(delegateName)
    delegateName = "delegateName1"
    delegateName = "delegateName2"

//    println(notNullName.length)

    val user1 = User1(mutableMapOf("name" to "jack", "age" to 1))
    println(user1.name)
}

//类的委托
interface Subject {
    fun hello()
}

class RealSubject(val name: String) : Subject {
    override fun hello() {
        println("hello $name,im realSubject")
    }
}

class ProxySubject(private val subject: Subject) : Subject by subject {
//    override fun hello() {
//        subject.hello()
//    }
}

//属性委托
//延迟属性（lazy properties）: 其值只在首次访问时计算
//可观察属性（observable properties）: 监听器会收到有关此属性变更的通知
//把多个属性储存在一个映射（map）中，而不是每个存在单独的字段中
val lazyName: String by lazy {
    "lazyName"
}

var delegateName: String by Delegates.observable("delegateName") { kProperty, old, new ->
    println("kProperty：${kProperty.name} , oldName:$old , newName:$new")
}

var vetoableName: String by Delegates.vetoable("lily") { kProperty, old, new ->
    new.contains("li")
}

var notNullName: String by Delegates.notNull<String>()

class User1(val map: MutableMap<String, Any?>) {
    val name by map
    val age by map
}

class DelegatePropertiesDemo {
    var content: String by Content()
    var des: String by Description()
}

class Content {
    operator fun getValue(delegatePropertiesDemo: DelegatePropertiesDemo, kProperty: KProperty<*>): String {
        return ""
    }

    operator fun setValue(delegatePropertiesDemo: DelegatePropertiesDemo, kProperty: KProperty<*>, value: String) {

    }
}

class Description : ReadWriteProperty<DelegatePropertiesDemo, String> {
    override fun getValue(thisRef: DelegatePropertiesDemo, property: KProperty<*>): String {
        return ""
    }

    override fun setValue(thisRef: DelegatePropertiesDemo, property: KProperty<*>, value: String) {

    }
}
