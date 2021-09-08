package lection.l14_soket.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread implements Runnable {
    private Socket socket;
    private Scanner scanner;
    private PrintWriter printWriter;
    private Server server;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        try {
            scanner = new Scanner(socket.getInputStream());
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //
        while (scanner.hasNextLine()) {
            String message = scanner.nextLine();
            System.out.println(message);
            server.sendMessageToAll(message);
            //
        }
    }

    public void sendMessage(String message) {
        printWriter.println(message);
        printWriter.flush();
    }
}
