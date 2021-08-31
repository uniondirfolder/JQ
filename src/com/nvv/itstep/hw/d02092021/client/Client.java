package com.nvv.itstep.hw.d02092021.client;

import com.nvv.itstep.hw.d02092021.general.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {
    private User owner;
    private Deque<Message> income;
    private Deque<Message> outcome;
    private Socket socket;
    private Scanner scannerNetwork;
    private PrintWriter printWriter;
    boolean interruptAll = false;


    public Client(String name, String address, int port) throws ConnectException {
        try {
            this.socket = new Socket(address, port);
            scannerNetwork = new Scanner(socket.getInputStream());
            printWriter = new PrintWriter(socket.getOutputStream());
            owner = new User(name);
            income = new LinkedList<>();
            outcome = new LinkedList<>();

        } catch (IOException e) {
            throw new ConnectException(e.getMessage());
        }
    }

    @Override
    public void run() {
        class Listener implements Runnable {
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
                    if (interruptAll){
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
            public void sendMessage(Message msg){
                printWriter.println(msg.toString());
                printWriter.flush();
            }
            @Override
            public void run() {
                while (true) {
                    if (outcome.size() > 0) {
                        Message msg = outcome.pop();
                        sendMessage(msg);
                    }
                    if (interruptAll){
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

        class Console implements Runnable {
            @Override
            public void run() {
                Long time = new Date().getTime();
                Scanner consoleIn = new Scanner(System.in);

                System.out.println("Initiate private chat");
                System.out.println("Print nick");
                String str = consoleIn.nextLine();

                owner.setName(str);
                printWriter.println(new Message(owner.getName(), "entered to chat", time.toString()));
                printWriter.flush();


                while (!interruptAll) {
                    System.out.println(consoleIn.hasNextLine());
                    if (consoleIn.hasNextLine()) {
                        str = consoleIn.nextLine();
                        time = new Date().getTime();
                        if (str.equals("exit")) {
                            outcome.addLast(new Message(owner.getName(), str, time.toString()));
                            interruptAll = true;
                        }
                        outcome.add(new Message(owner.getName(), str, time.toString()));

                        while (income.size() > 0) {
                            Message msg = income.pop();
                            System.out.println(msg.print());
                        }
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Thread th1 = new Thread(new Listener());
        Thread th2 = new Thread(new Sender());
        Thread th3 = new Thread(new Console());
        th1.start();
        th2.start();
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th3.start();

        try {
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exit from chat.");
    }

}

