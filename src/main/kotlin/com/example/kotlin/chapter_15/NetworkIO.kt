package com.example.kotlin.chapter_15

import java.net.URL

fun main(args: Array<String>) {

    val content = URL("http://test-api-blocks.ptdev.cn/block/all").readText()
    println(content)
}