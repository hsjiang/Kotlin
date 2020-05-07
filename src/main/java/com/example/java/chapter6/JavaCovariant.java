package com.example.java.chapter6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaCovariant {

    public static void main(String[] args) {

        //数组是协变的
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


        //协变
        List<? extends Number> list1 = new ArrayList<Integer>();
        List<? extends Number> list2 = new ArrayList<Float>();
        list1.add(null);
        list2.add(null);
//        list1.add(new Integer(1));
//        list2.add(new Float(1.2f));

        //逆变
        List<? super String> sList1 = new ArrayList<CharSequence>();//消费者
        List<? extends String> sList2 = new ArrayList<>();//生产者
//        sList1.add(sList2.get(0));

        Collections.copy(new ArrayList<Number>(), new ArrayList<Integer>());

        ArrayList<? super String> list3 = new ArrayList();
        list3.add("");
//        list3.add(1);
        Object s = list3.get(1);
    }
}
