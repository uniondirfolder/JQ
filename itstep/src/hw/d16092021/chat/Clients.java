package hw.d16092021.chat;


import hw.d16092021.client.UIClient;


public class Clients {
    public static void main(String[] args) {

        Thread th = new Thread(new Th1());
        th.start();
        UIClient cl = new UIClient();

        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Th1 implements Runnable{

        @Override
        public void run() {
            new UIClient();
        }
    }
}

