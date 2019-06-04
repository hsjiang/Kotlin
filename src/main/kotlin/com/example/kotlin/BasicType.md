# 基本类型
### 数字
* 对于数字没有隐式拓展转换(如java中可以将int类型自动转换为long)
* kotlin中字符不是数字

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


