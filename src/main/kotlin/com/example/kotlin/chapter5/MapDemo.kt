package com.example.kotlin.chapter5

fun main(args: Array<String>) {
    val immutableMap = mapOf(1 to "a", 2 to "b", 3 to "c")
    println(immutableMap::class)
    println(immutableMap)
    println(immutableMap.keys)
    println(immutableMap.values)
    println(immutableMap.get(4))
    println(immutableMap[4])
    println(immutableMap.getValue(3))
//    println(immutableMap.getValue(4)) //NoSuchElementException
    println(immutableMap[4])
//    immutableMap[1] = "a"
    immutableMap.entries.forEach { print("${it.key} ${it.value},") }
    println()
    immutableMap.forEach { print("${it.key} ${it.value},") }
    println()
    immutableMap.entries

    println()
    val mutableMap = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    println(mutableMap::class)
    println(mutableMap)
    mutableMap[1] = "aa"
    println(mutableMap)
    println("put 4,d return " + mutableMap.put(4, "d"))
    mutableMap[4] = "d"
    println(mutableMap)
    mutableMap.getOrPut(5) { "e" }
    println(mutableMap)

    println()
    val hashMap = hashMapOf<Int, String>()
    println(hashMap::class)

    println()
    val linkedHashMap = linkedMapOf<Int, String>()
    println(linkedHashMap::class)

}