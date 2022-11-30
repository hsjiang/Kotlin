package com.example.kotlin

import java.io.File

fun main() {
    val file = File("/Users/hushoujiang/lib")
    val newFile = File("/Users/hushoujiang/riven/github/kotlin/code.txt")
    newFile.createNewFile()
    readFile(file, newFile)
}

fun readFile(file: File, targetFile: File) {
    file.listFiles().forEach {
        if (it.isDirectory) {
            readFile(it, targetFile)
        } else {
            targetFile.appendText(it.readText())
        }
    }
}