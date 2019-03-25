package com.example.kotlin.chapter9

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CoroutinesAndDaemonThreadTest {
    @Test
    fun daemonThreadTest(){
        daemonThread()
    }

    @Test
    fun coroutineDaemonTest(){
        coroutineDaemon()
    }
}