package com.nvv.itstep.lection.thread.thread2;

public class Main {
    public static void main(String[] args) {
        System.out.println("start " + Thread.currentThread().getName());

        Thread thread = new Thread(new MyThread());
        thread.start();

        System.out.println("finish " + Thread.currentThread().getName());
    }
}
