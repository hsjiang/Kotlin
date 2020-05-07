#类与继承

### 调用超类实现
```kotlin
class Bar : Foo() {
    override fun f() { /* …… */ }
    override val x: Int get() = 0
    
    inner class Baz {
        fun g() {
            super@Bar.f() // 调用 Foo 实现的 f()
            println(super@Bar.x) // 使用 Foo 实现的 x的 getter
        }
    }
}
```

###覆盖规则
如果一个类从他的直接超类继承相同成员的多个实现，他必须覆盖这个成员并提供自己的实现

```kotlin
open class A {
    open fun f() { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } // 接口成员默认就是“open”的
    fun b() { print("b") }
}

class C() : A(), B {
    // 编译器要求覆盖 f()：
    override fun f() {
        super<A>.f() // 调用 A.f()
        super<B>.f() // 调用 B.f()
  }
}
```

###抽象类
我们可以用一个抽象的成员覆盖一个非抽象的开放成员

```kotlin
open class Base {
    open fun f() {}
}

abstract class Derived : Base() {
    override abstract fun f()
}
```