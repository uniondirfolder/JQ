package com.nvv.itstep.lection;

public class Stub {
    public static void main(String[] args) {
        String s = "s1";
        String s2 = new String("s1");
        String s3 = "s1";
        String s4 = s;

        System.out.println(s == s2);
        System.out.println(s.equals(s2));
        System.out.println(s==s3);
        System.out.println(s.equals(s3));
        System.out.println(s==s2);
        System.out.println(s.equals(s2));
    }
}
