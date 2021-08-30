package com.nvv.itstep.lection.l15_sobes.q11;

public class Test {
    static String str = "Value 1";
    static String[] strings = {"one"};
    public static void changeIt(String s) {
        s = "Value 2";
    }

    public static void changeIt(String[] s) {
        s[0] = "two";
    }

    public static void main(String[] args) {
//        changeIt(str);
//        System.out.println(str);

        changeIt(strings);
        System.out.println(strings[0]);

    }
}
