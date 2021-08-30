package com.nvv.itstep.lection.thread.thread7;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new CounterThread());
        Thread thread2 = new Thread(new CounterThread());
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(CounterThread.count);
        System.out.println(CounterThread.atomicInteger.get());
    }
}
