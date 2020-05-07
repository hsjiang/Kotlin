# 基本类型
### 数字
* 对于数字没有隐式拓展转换(如java中可以将int类型自动转换为long)
* kotlin中字符不是数字

```
fun check(c: Char) {
    if (c == 1) { // 错误：类型不兼容,java中可以
    }
}
```

### 数字字面值中的下划线
```kotlin
val money = 1_000_000_000
```

### 表示方式
使用可空引用或泛型会将数字自动装箱，保留相等性，不一定保留同一性:

```kotlin
fun main() {
    val a: Int = 1000
    val b: Int = 1000

    println(a == b)//true
    println(a === b)//false

    val c: Int? = 1000
    val d: Int? = 1000

    println(a == c)//true
    println(a === c)//false

    println(c == d)//true
    println(c === d)//false

    val e:Int? = a
    val f:Int? = a
    println(e == f)//true
    println(e === f)//false
}
```

* 如果上述取值在`-128 - 127之间`，则结果全为`true`，这点和`java`中相同

### 显示转换
```kotlin
fun main() {
    val a: Int? = 1 // 一个装箱的 Int, 字面值是静态检测的
    //val b: Long? = a //error,较小的类型不能隐式转换为较大的类型
    val b: Long? = a?.toLong() // ok,显示转换
}
```
### 运算
`kotlin`支持数字运算的标准集，运算被定义为相应的类成员(编译器会将函数调用优化为相应的指令)[运算符重载](https://www.kotlincn.net/docs/reference/operator-overloading.html)

对于位运算，没有特殊符号表示，只可用中缀方式调用命名函数

* `kotlin`–`java`
* `shl`   – `<<`
* `shr`   –  `>>`
* `ushr`  – `>>>`
* `and`   – `&`
* `or`    – `|`
* `xor`   – `^`
* `inv`   – `~`

### 字符
特殊字符可以用反斜杠转义，支持`\t`,`\b`,`\n`,`\r`,`\'`,`\"`,`\\`,
`\\`,编码其他字符要用unicode字符转义序列语法：`\uFF00`

### 数组
* 与`java`不同的是`kotlin`中数组不是型变的，这意味着`kotlin`不允许我们把`Array<String>`赋值给`Array<Any>`，以防止可能的运行时失败，但可以使用`Array<out Any>`

### [无符号整型(1.3引入，目前实验性阶段)](https://www.kotlincn.net/docs/reference/basic-types.html#%E6%97%A0%E7%AC%A6%E5%8F%B7%E6%95%B4%E5%9E%8B)

### 字符串







