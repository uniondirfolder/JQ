package hw.d16092021.client;

import hw.d16092021.general.ConnectException;

public interface Exchange {
    void sendMessage(String msg) throws ConnectException;
    void getMessage(String msg);
}
