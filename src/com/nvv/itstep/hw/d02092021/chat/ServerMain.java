package com.nvv.itstep.hw.d02092021.chat;

import com.nvv.itstep.hw.d02092021.server.Server;

public class ServerMain {
    public static void main(String[] args) {
        Server server = new Server(45000);
        server.start();
    }
}

