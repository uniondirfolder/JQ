package com.nvv.itstep.lection.l15_sobes.q7;

public class Main {
    public static void main(String[] args) {
       test(2, 2);
    }

    public static void test(Integer a, Integer b) {
        System.out.println("method1");
    }

    public static void test(int... numbers) {
        System.out.println("method2");
    }

    public static void test(long a, long b) {
        System.out.println("method3");
    }
}
