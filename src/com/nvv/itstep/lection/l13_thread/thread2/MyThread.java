package com.nvv.itstep.lection.l13_thread.thread2;

public class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("start "  + Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("myThread finish " + Thread.currentThread().getName());
    }
}
