package com.example.kotlin.chapter4


fun main(args: Array<String>) {
    val originS = """  abc
        ...|def"""

    println(originS)
    println(originS.trimMargin("...|"))
    println(originS.trimIndent())

    val s = "abcdef"

    println(s[2])

    for (c in s) {
        print("$c ")
    }

    println()

    println(s + 10L)
    println(s + 1.20f)
    println(s + null)

    val str: String = "aabbccddee"
    str.forEach { print("$it ") }

    println()

    val price1 = "$str.99"
    val price2 = "\$str.99"
    //原始字符串与转义字符串内部都支持模板。 如果你需要在原始字符串中表示字面值 $ 字符（它不支持反斜杠转义）
    val price3 = """$${'$'}9.99$\$str"""
    val price4 = "$9.99"
    println(price1)
    println(price2)
    println(price3)
    println(price4)
}