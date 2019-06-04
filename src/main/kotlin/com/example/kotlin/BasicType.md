# 基本类型
### 数字
* 对于数字没有隐式拓展转换(如java中可以将int类型自动转换为long)
* kotlin中字符不是数字

### 数字字面值中的下划线
```kotlin
	val money = 1_000_000_000
```

### 表示方式
使用可空引用或泛型会将数字装箱，保留相等性，不一定保留同一性:

<div class="sample" markdown="1" theme="idea">

```kotlin
fun main(){
//sampleStart
	val a:Int = 100
	val b:Int = 100
	println(a == b)
	println(a === b)
//sampleEnd
}
```
</div>