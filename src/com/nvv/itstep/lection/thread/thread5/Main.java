package com.nvv.itstep.lection.thread.thread5;

public class Main {
    public static void main(String[] args) {
        System.out.println("start");

        CounterThread counterThread = new CounterThread();
        counterThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //counterThread.stop();
        if (counterThread.getState() == Thread.State.TIMED_WAITING) {
            System.out.println("НЕЛьзЯ!");
        } else {
            System.out.println("можно!");
        }
        System.out.println(counterThread.getState());
        counterThread.interrupt();


        System.out.println("finish");
    }
}
