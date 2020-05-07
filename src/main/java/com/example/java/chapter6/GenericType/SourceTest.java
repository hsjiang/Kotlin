package com.example.java.chapter6.GenericType;

public class SourceTest {

    public static void main(String[] args) {

    }

    static void demo(Source<String> strs) {
        // ！！！在 Java 中不允许
//        Source<Object> objects = strs;
//        Source<CharSequence> charSequences = strs;

        //在kotlin中可以用 声明处型变 Source<out T> 解决该现象

        Source<? extends CharSequence> charSequences = strs;
    }
}
