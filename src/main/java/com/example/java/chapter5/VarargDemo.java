package com.example.java.chapter5;

public class VarargDemo<T> {

    public String append(T... elements) {
        StringBuilder builder = new StringBuilder();
        if (elements != null) {
            for (T element : elements) {
                builder.append(element);
            }
        }
        return builder.toString();
    }
}
