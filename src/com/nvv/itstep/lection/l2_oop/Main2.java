package com.nvv.itstep.lection.l2_oop;

public class Main2 {
    public static void main(String[] args) {

//        String a = new String("one");
//        String b = new String("one");//alt + enter
//        System.out.println(a == b);//false//сравниваем ссылки
//        System.out.println(a.equals(b));//true


//        String a = "one";
//        String b = "one";
//        b = "two";
//        System.out.println(a);
//        System.out.println(a == b);//true
//        System.out.println(a.equals(b));//true

//        Scanner scanner = new Scanner(System.in);
//        String a = scanner.nextLine();
//        String b = scanner.nextLine();
//        System.out.println(a == b);//false
//        System.out.println(a.equals(b));

//        long l1 = System.currentTimeMillis();
//        String s = null;
//        for (int i = 0; i < 100_000; i++) {
//            s += i;
//        }
//        long l2 = System.currentTimeMillis();
//        System.out.println(l2 - l1);//40сек

//        long l1 = System.currentTimeMillis();
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i < 100_000; i++) {
//            s.append(i);
//        }
//        long l2 = System.currentTimeMillis();
//        System.out.println(l2 - l1);//40мсек

        String s = "word";
        s.toUpperCase();
        System.out.println(s);
        System.out.println(s.toUpperCase());
    }
}
