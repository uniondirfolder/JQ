package com.nvv.itstep.hw.d02092021.chat;


import com.nvv.itstep.hw.d02092021.client.Client;
import com.nvv.itstep.hw.d02092021.general.ConnectException;

import java.util.concurrent.TimeUnit;

public class ClientMain {


    public static void main(String[] args) {
        try {
            Thread th = new Thread(new Client("Vova","localhost", 45000));
            th.start();
        } catch (ConnectException e) {
            System.out.println(e.getMessage());
        }
    }
}
