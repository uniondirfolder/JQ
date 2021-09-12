package hw.d02092021.client;

import hw.d02092021.general.ConnectException;

public interface Exchange {
    void sendMessage(String msg) throws ConnectException;
    void getMessage(String msg);
}
