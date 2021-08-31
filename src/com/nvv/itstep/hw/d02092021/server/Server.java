package com.nvv.itstep.hw.d02092021.server;

import com.nvv.itstep.hw.d02092021.general.Message;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Server {
    private int port;
    private List<Message> messageList;
    private List<ClientSocket> clientSocketList;
    private Object lock = new Object();

    public Server(int port) {
        this.port = port;
        this.messageList = new LinkedList<>();
        Long time = new Date().getTime();
        this.messageList.add(new Message("admin", "hello ysem!", time.toString()));
        this.clientSocketList = new LinkedList<>();
    }

    public void start() {
        System.out.println("start");
        Thread ths = new Thread(new Sender());
        ths.start();

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("created");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("connected " + socket.getInetAddress() + " " + socket.getPort());
                ClientSocket cs = new ClientSocket(socket);
                Thread th = new Thread(cs);
                th.start();
                clientSocketList.add(cs);
                System.out.println("New client");
                System.out.println("Active clients => " + clientSocketList.size());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("stop");
    }


    class Sender implements Runnable {
        private int nextSend = 0;

        @Override
        public void run() {
            if (messageList.size() > nextSend) {
                for (Iterator<ClientSocket> iterator = clientSocketList.iterator(); iterator.hasNext(); ) {
                    ClientSocket next = iterator.next();
                    for (int i = nextSend, j = messageList.size(); i < j; i++) {
                        next.sendMsg(messageList.get(i).toString());
                    }
                }
                nextSend = messageList.size()-1;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class ClientSocket implements Runnable {
        private Socket socket;
        private Scanner readFromClient;
        private PrintWriter sendToClient;
        private Message msg;
        private boolean clientExit = false;

        public ClientSocket(Socket socket) {
            this.socket = socket;
            try {
                this.readFromClient = new Scanner(socket.getInputStream());
                this.sendToClient = new PrintWriter(socket.getOutputStream());
                Long time = new Date().getTime();
                this.msg = new Message("server", "WELCOME to CHAT", time.toString());
                sendMsg(msg.toString());
                for (Message msg : messageList) {
                    sendMsg(msg.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendMsg(String msg) {
            sendToClient.println(msg);
            sendToClient.flush();
        }

        @Override
        public void run() {
            while (!clientExit) {
                if (readFromClient.hasNextLine()) {
                    msg = new Message(readFromClient.nextLine());
                    if (!msg.isEmpty()) {
                        messageList.add(new Message(msg));
                        System.out.println(msg.print());
                        if (("exit").equals(msg.getBody())) {
                            clientExit = true;
                        }
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int count = 0;
            for (Iterator<ClientSocket> iterator = clientSocketList.iterator(); iterator.hasNext(); ) {
                ClientSocket next = iterator.next();
                if (next.equals(this)) {
                    clientSocketList.remove(count);
                    break;
                }
                count++;
            }
            System.out.println("Active clients => " + clientSocketList.size());

            if (socket != null && !socket.isClosed()) {
                msg = null;
                readFromClient.close();
                sendToClient.close();
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ClientSocket)) return false;
            ClientSocket that = (ClientSocket) o;
            return socket.equals(that.socket) && readFromClient.equals(that.readFromClient) && sendToClient.equals(that.sendToClient) && msg.equals(that.msg);
        }

        @Override
        public int hashCode() {
            return Objects.hash(socket, readFromClient, sendToClient, msg);
        }
    }
}
