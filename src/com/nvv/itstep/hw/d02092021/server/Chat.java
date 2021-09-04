package com.nvv.itstep.hw.d02092021.server;

import com.nvv.itstep.hw.d02092021.client.Client;

public interface Chat {
    void start();
    void sendMessage(String msg, Client client);
}
