package com.nvv.itstep.lection.l15_sobes.q10;

interface A {
   public static final String text = "a";
}

interface B {
    public static final String text = "b";
}

public class Implementor implements A, B {
    public static void main(String[] args) {
       //System.out.println(Implementor.text);
        System.out.println(((A) new Implementor()).text);
        System.out.println(((B) new Implementor()).text);

    }
}

















































