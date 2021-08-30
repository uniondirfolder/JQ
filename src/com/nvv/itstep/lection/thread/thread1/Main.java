package com.nvv.itstep.lection.thread.thread1;

public class Main {
    public static void main(String[] args) {
        System.out.println("start " + Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("finish " + Thread.currentThread().getName());
    }
}
