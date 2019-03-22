package com.example.kotlin.chapter3

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.lang.reflect.Array.getLength

@RunWith(JUnit4::class)
class IsDemoTest {

    @Test
    fun testGetLength() {
        val obj = "abcdef"
        getLength(obj)

        val obj1 = 10
        getLength(obj1)

        val obj2 = Any()
//        getLength(obj2)
    }
}
