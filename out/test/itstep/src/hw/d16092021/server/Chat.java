package hw.d16092021.server;

import hw.d16092021.client.Client;

public interface Chat {
    void start();
    void sendMessage(String msg, Client client);
}
