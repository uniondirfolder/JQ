package com.nvv.itstep.lection.l10_exc_enum;

public class Main {
    public static void main(String[] args) {
        //unchecked

        //ArrayIndexOutOfBoundsException
//        System.out.println("Hello World!");
//        int[] arr = new int[3];
//        int index = 7;
//        System.out.println(arr[index]);

        //ArithmeticException
//        int a = 3;
//        int b = 0;
//        System.out.println(a / b);

        //
//        String s = getData(-3);
//        System.out.println(s.toUpperCase());

//        User user = new User();
//        System.out.println(user.getAge());
//        System.out.println(user.getName().toUpperCase());

//        String name = null;
//        System.out.println(name);

        int a = 3;
        int b = 0;
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("на ноль делить нельзя");
        }
        System.out.println("finish");
    }

//    private static String getData(int key) {
//        if (key > 0) {
//            return "test";
//        }
//        return null;
//    }
}
