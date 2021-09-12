package lection.l13_thread.thread6;

public class Volatile {
    private volatile boolean exit = false;//true

    public void start() {

        new Thread(() -> {
            Thread.currentThread().setName("first");
            System.out.println(Thread.currentThread().getName() + " started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            exit = true;
            System.out.println(Thread.currentThread().getName() + " finished");
        }).start();

        new Thread(() -> {
            Thread.currentThread().setName("second");
            System.out.println(Thread.currentThread().getName() + " started");
            while (!exit) {

            }
            System.out.println(Thread.currentThread().getName() + " finished");
        }).start();
    }
}
