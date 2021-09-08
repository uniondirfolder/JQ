package lection.l14_soket.client.client1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerListener implements Runnable{
    private Socket socket;
    private Scanner scannerNetwork;


    public ServerListener(Socket socket) {
        this.socket = socket;
        try {
            scannerNetwork = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (scannerNetwork.hasNextLine()) {
            System.out.println(scannerNetwork.nextLine());
        }
    }
}
