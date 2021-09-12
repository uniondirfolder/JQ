package lection.l13_thread.thread1;

public class MyThread extends Thread {
    //ctrl + O

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
