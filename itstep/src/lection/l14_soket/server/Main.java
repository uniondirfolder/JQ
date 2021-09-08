package lection.l14_soket.server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(54321);
        server.start();
    }
}

