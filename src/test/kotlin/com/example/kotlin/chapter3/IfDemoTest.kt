package com.example.kotlin.chapter3

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class IfDemoTest {
    @Test
    fun maxTest() {
        max(5, 10)
    }

    @Test
    fun max2Test() {
        max2(15, 10)
    }
}