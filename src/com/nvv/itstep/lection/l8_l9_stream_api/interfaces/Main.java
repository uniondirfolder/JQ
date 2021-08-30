package com.nvv.itstep.lection.l8_l9_stream_api.interfaces;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
//        Predicate<Integer>isPositive = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer > 0;
//            }
//        };

        //Predicate<Integer> isPositive = v -> v > 0;
        Predicate<Integer> isPositive = NumberUtil::isPositive;

        System.out.println(isPositive.test(5));

    }
}
