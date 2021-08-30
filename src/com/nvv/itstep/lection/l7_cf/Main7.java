package com.nvv.itstep.lection.l7_cf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main7 {
    public static void main(String[] args) {
//        List<Integer> numbers = new ArrayList<>();
//        long l1 = System.currentTimeMillis();
//        for (int i = 0; i < 100_000; i++) {
//            numbers.add(1);
//        }
//        long l2 = System.currentTimeMillis();
//        System.out.println(l2 - l1);//11


        LinkedList<Integer> numbers = new LinkedList<>();
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            numbers.addLast(1);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);//12
    }
}
