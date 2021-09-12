package hw.d16092021.client;

import hw.d16092021.general.ConnectException;
import hw.d16092021.general.Developer;
import hw.d16092021.general.Message;
import hw.d16092021.general.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Developer
public class Client extends Thread implements Exchange {
    private User owner;
    private Deque<Message> income;
    private Deque<Message> outcome;
    private Socket socket;
    private Thread listener;
    private Thread sender;
    volatile boolean interruptAll = false;
    private UIClient uiClient;

    @Override
    public void sendMessage(String msg) throws ConnectException {
        if (msg.contains("%")) {
            uiClient.printMsg("Unregistered symbol! - % )");
        }
        if (msg.equals("exit")) {
            System.out.println("... start close connect, wait...");
            interruptAll = true;
        }
        Long l = new Date().getTime();
        owner.setName(uiClient.getNickName());
        outcome.add(new Message(owner.getName(), msg, l.toString()));
    }

    @Override
    public void getMessage(String msg) {
        uiClient.printMsg(msg);
    }

    public Client(UIClient uiClient) throws IOException {
        this.uiClient = uiClient;
        this.socket = new Socket(uiClient.getIP_ADDRESS(), uiClient.getPORT());
        owner = new User(uiClient.getNickName());
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
                getMessage(income.pop().print());
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

