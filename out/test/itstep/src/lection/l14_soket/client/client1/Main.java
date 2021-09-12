package lection.l14_soket.client.client1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 54321);
            new Thread(new ServerListener(socket)).start();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            Scanner scannerConsole = new Scanner(System.in);
            while (true) {
                printWriter.println(scannerConsole.nextLine());
                printWriter.flush();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Сервер недоступен");
        }
    }
}
