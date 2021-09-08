package lection.l13_thread.thread7;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterThread implements Runnable {
    //public volatile static int count = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            //count++;
            atomicInteger.incrementAndGet();
        }
    }
}
