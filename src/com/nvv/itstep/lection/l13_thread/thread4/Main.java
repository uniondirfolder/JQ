package com.nvv.itstep.lection.l13_thread.thread4;


import com.nvv.itstep.lection.l13_thread.thread2.MyThread;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started");
        Thread thread = new Thread(new MyThread());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
