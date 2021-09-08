package hw.d02092021.chat;

import hw.d02092021.server.Server;

public class ServerMain {
    public static void main(String[] args) {
        Server server = new Server(45000);
        server.start();
    }
}

