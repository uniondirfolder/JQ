package lection.l13_thread.thread3;

public class Main {
    public static void main(String[] args) {
        System.out.println("start");

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("I'm new Thread");
//            }
//        });
//        thread.start();

//        Thread thread = new Thread(() -> System.out.println("I'm new Thread"));
//        thread.start();

       new Thread(() -> System.out.println("I'm new Thread")).start();

        System.out.println("finish");
    }
}
