package com.example.kotlin.chapter5

fun main(args: Array<String>) {
    val emptyList = listOf<Int>()
    val list = listOf(1, 2, 3, 4, 5)
    val singletonList = listOf("1")

    val arrayList = arrayListOf(1, 2, 3, 4)
    arrayList.add(5)
    println(arrayList)

    val mutableList = mutableListOf(1, 2, 3, 4)
    println(mutableList::class)

    list.forEach {
        print("$it ")
    }
    println()

    list.forEach(::print)


    println()
    var element = list.elementAtOrElse(2, defaultValue = { "$it sss" })
    println("element: $element")

    var single = list.singleOrNull { it == 3 }
    println(single)

    list.any()
    list.none()
    println(list.reduce(::add))
    println(list.fold(1) { a, b -> a + b })

    val list2 = listOf("a", "b", "c", "d", "e")
    println(list2.reduce { a, b -> a + b })
    println(list2.reduceRight { a, b -> b + a })

    list.forEachIndexed { index, i ->
        print("$index : $i  ")
    }

    println()

    println(list.maxByOrNull { if (it > 2) it - 3 else it })

    println(list.sumBy { it + 1 })


    val list3 = listOf(2, 4, 6, 8, 9, 10, 11, 12, 16)
    println(list3.takeWhile { it % 2 == 0 })
    println(list3.takeLastWhile { it % 2 == 0 })
    println(list3.dropWhile { it % 2 == 0 })
    //开始下标至结束下标元素集合
    println(list3.slice(2..6))

    val dest = mutableListOf<Int>()
    println(list3.filterTo(dest) { it > 9 })

    println(list2.map { listOf(it + 1, it + 2, it + 3) })
    println(list2.flatMap { listOf(it + 1, it + 2, it + 3) })

    println(list3.groupBy { it % 2 })

    println(list3.groupBy({ it % 3 }, { it }))

    val list4 = listOf("K&R" to "C", "BJar" to "C++", "Linus" to "C", "James" to "Java")
    println(list4)
    println(list4.groupingBy { it.second }.eachCount())
}

fun add(i1: Int, i2: Int): Int {
    return i1 + i2
}

