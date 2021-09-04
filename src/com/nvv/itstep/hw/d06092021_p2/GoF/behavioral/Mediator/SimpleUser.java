package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.Mediator;

public class SimpleUser implements User {
    String name;
    Chat chat;

    public SimpleUser(String name, Chat chat) {
        this.name = name;
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.name + " receive message: " + message + ".");
    }
}
