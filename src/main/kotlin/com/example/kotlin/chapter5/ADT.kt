package com.example.kotlin.chapter5

//抽象数据类型

//数据结构主要解决以下三个问题
//1.数据元素之间的逻辑关系，有集合，线性结构，树形结构，图形结构等
//2.数据的物理结构，有顺序(数组，ArrayList)、链接(LinkedList)、索引、散列等
//3.数据的处理运算

fun main(args: Array<String>) {
    mutableListOf(1, 2, 3).sortWith(Comparator { x, y ->
        x.compareTo(y)
    })

    val runnable = Runnable {  }
}