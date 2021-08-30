package com.nvv.itstep.lection.l10_exc_enum;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main1 {
    public static void main(String[] args) {
        //checked
//        System.out.println("start");
//        try {
//            Thread.sleep(5000);//alt + enter
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            System.out.println("catch");
//        }
//        System.out.println("finish");

       method1();
    }

    public static void method1() {
        method2();
    }
    public static void method2() {
        //FileNotFoundException
//        try {
//            PrintWriter printWriter = new PrintWriter("F://hello");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            //System.out.println("попали в catch");
//        }

        try {
            PrintWriter printWriter = new PrintWriter("hello");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
