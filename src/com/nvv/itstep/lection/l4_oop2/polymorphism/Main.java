package com.nvv.itstep.lection.l4_oop2.polymorphism;

public class Main {
    public static void main(String[] args) {
        //Полиморфизм - один интерфейс, много реализаций
//        System.out.println(2 + 2);
//        System.out.println("2" + "2");

        byte b1 = 1;
        byte b2 = 1;
        sum(b1, b2);

        sum(2, 2.0);
        sum(b1, 2.0);
        //sum(2.5, 2.0);
        //sum(2, 3, 3);
    }


    public static void sum(int a, double b) {
        System.out.println("two double");
        System.out.println(a + b);
    }

    public static void sum(short a, double b) {
        System.out.println("two");
        System.out.println(a + b);
    }

    public static void sum(double a, double b) {
        System.out.println("two double");
        System.out.println(a + b);
    }

    public static void sum(short a, short b) {
        System.out.println("two");
        System.out.println(a + b);
    }

    public static void sum(int a, int b) {
        System.out.println("two");
        System.out.println(a + b);
    }

    public static void sum(int a, int b, int c) {
        System.out.println("three");
        System.out.println(a + b + c);
    }
}
