#
### 幕后字段
如果属性至少有一个访问器使用默认实现，或自定义访问器用`field`引用字段，将会为该属性生成一个幕后字段

`field`标识符只能用在属性的访问器内。

```kotlin
 	var name = ""
        set(value) {
            field = if (gender == 1) "mr.$value" else "ms.$value"
        }

    var size = 0
    //isEmpty没有幕后字段(没有默认访问器，并且没有field)
    var isEmpty
        get() = size == 0
        set(value) {
            size = if (value) 0 else size
        }
```

###幕后属性
一般使用场景为：对外表现为只读，对内表现为可读可写，例如`AbstractList `中的`size`和`_size`等

###编译期常量
需要满足以下条件

* 在顶层或者object或者companion object的一个成员
* 以`String `或者原生类型值出事化
* 没有自定义getter

###延迟初始化属性与变量
检测一个`lateinit var`是否已经初始化

