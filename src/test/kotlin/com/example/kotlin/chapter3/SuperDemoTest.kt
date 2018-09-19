package com.example.kotlin.chapter3

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SuperDemoTest {
    @Test
    fun loveTest() {
        val son = Son()
        son.love()
    }
}