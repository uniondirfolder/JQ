package itstep.hw.d02092021.chat;


import itstep.hw.d02092021.client.Client;
import itstep.hw.d02092021.general.ConnectException;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class ClientMain2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Initiate private chat");
        System.out.print("Your nick? > ");
        String str = sc.nextLine();
        if (str.isEmpty()) str = "anonymous";

        Client cli = null;
        try {
            cli = new Client(str, "localhost", 45000);
            cli.start();
            System.out.println("For escape type > exit");

            while (true) {
                str = sc.nextLine();
                if (!str.isEmpty()) {
                    try {
                        cli.sendMessage(str);
                    } catch (ConnectException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (str.equals("exit")) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
