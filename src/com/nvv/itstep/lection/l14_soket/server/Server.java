package com.nvv.itstep.lection.l14_soket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private int port;
    private ArrayList<ClientThread> clients;

    public Server(int port) {
        this.port = port;
        clients = new ArrayList<>();
    }

    public void start() {
        System.out.println("start");
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("created");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("connected " + socket.getInetAddress() + " " + socket.getPort());
                ClientThread clientThread = new ClientThread(socket, this);//не очень
                clients.add(clientThread);
                new Thread(clientThread).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("stop");
    }

    public void sendMessageToAll(String message) {
        clients.forEach((client) -> client.sendMessage(message));
    }
}
