package com.nvv.itstep.hw.d02092021.client;

import com.nvv.itstep.hw.d02092021.general.*;
import com.nvv.itstep.hw.d04092021.Developer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.TimeUnit;
@Developer
public class Client extends Thread {
    private User owner;
    private Deque<Message> income;
    private Deque<Message> outcome;
    private Socket socket;
    private Thread listener;
    private Thread sender;
    volatile boolean interruptAll = false;

    public void sendMessageToServer(String msg) throws ConnectException {
        if (msg.contains("%")) {
            throw new ConnectException("Unregistered symbol! - % )");
        }
        if (msg.equals("exit")) {
            System.out.println("... start close connect, wait...");
            interruptAll = true;
        }
        Long l = new Date().getTime();
        outcome.add(new Message(owner.getName(), msg, l.toString()));

    }

    public Client(String name, String address, int port) throws IOException {
            this.socket = new Socket(address, port);
            owner = new User(name);
            income = new LinkedList<>();
            outcome = new LinkedList<>();
            this.listener = new Thread(new Listener(this.socket));
            this.sender = new Thread(new Sender(this.socket));
            this.listener.start();
            this.sender.start();
    }

    class Listener implements Runnable {
        private Scanner scannerNetwork;

        Listener(Socket socket) {
            try {
                scannerNetwork = new Scanner(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            Message msg;
            while (true) {
                if (scannerNetwork.hasNextLine()) {
                    msg = new Message(scannerNetwork.nextLine());
                    if (!msg.isEmpty()) {
                        income.add(new Message(msg));
                    }
                }
                if (interruptAll) {
                    System.out.println("Close listening...");
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Sender implements Runnable {
        private PrintWriter printWriter;

        Sender(Socket socket) {
            try {
                printWriter = new PrintWriter(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                while (outcome.size() > 0) {
                    printWriter.println(outcome.pop().toString());
                    printWriter.flush();
                }
                if (interruptAll) {
                    System.out.println("Close sending...");
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        while (!interruptAll) {
            while (income.size() > 0) {
                System.out.println(income.pop().print());
            }
            if (interruptAll) {
                System.out.println("Close printing...");
                break;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

