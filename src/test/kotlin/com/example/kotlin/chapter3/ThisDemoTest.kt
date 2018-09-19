package com.example.kotlin.chapter3

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ThisDemoTest {

    @Test
    fun whatIsThisTest() {
        val demo = ThisDemo()
        println(demo.whatIsThis())
    }

    @Test
    fun sumTest() {
        val demo = ThisDemo()
        println(demo.sum())
    }

    @Test
    fun concatTest() {
        val demo = ThisDemo()
        println(demo.concat)
        println(demo.concat())
    }

    @Test
    fun mTest() {
        val demo = ThisDemo2()
        demo.Inner().m()
    }
}