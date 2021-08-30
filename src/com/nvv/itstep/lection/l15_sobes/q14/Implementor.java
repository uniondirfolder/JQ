package com.nvv.itstep.lection.l15_sobes.q14;

public class Implementor implements First, Second {

    @Override
    public void method() {
        //???
        First.super.method();
        Second.super.method();
    }

    public static void main(String[] args) {
        Implementor implementor = new Implementor();
        implementor.method();
    }
}





































