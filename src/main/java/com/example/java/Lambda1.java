package com.example.java;

public class Lambda1 {

    public static void main(String[] args) {
        G<String, Integer> g = String::length;

        System.out.print(g.apply("hahha"));
    }

    interface G<A, B> {
        B apply(A a);
    }
}
