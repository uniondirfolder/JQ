package com.nvv.itstep.lection.thread.thread5;

public class CounterThread extends Thread {
    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted()) {
            //получает данные
            System.out.println(count++);//обрабатывает данные
            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            //сохраняет данные
        }
    }
}
