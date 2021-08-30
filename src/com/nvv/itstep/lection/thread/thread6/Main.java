package com.nvv.itstep.lection.thread.thread6;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started");
        Volatile v = new Volatile();
        v.start();
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
