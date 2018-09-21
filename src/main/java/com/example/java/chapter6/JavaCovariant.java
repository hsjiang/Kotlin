package com.example.java.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaCovariant {

    public static void main(String[] args) {

        //数组协变
        Integer[] ints = new Integer[3];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        Number[] numbers = ints;
        for (Number n : numbers) {
            System.out.println(n);
        }

        List<? extends Number> list = new ArrayList();
//        list.add(new Integer(1)); //error


        //协变与逆变
        List<? extends Number> list1 = new ArrayList<Integer>();
        List<? extends Number> list2 = new ArrayList<Float>();
        list1.add(null);
        list2.add(null);
//        list1.add(new Integer(1));
//        list2.add(new Float(1.2f));


        //协变与逆变
        Collections.copy(new ArrayList<Number>(), new ArrayList<Integer>());
    }
}
