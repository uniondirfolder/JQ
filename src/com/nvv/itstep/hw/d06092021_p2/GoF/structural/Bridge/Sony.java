package com.nvv.itstep.hw.d06092021_p2.GoF.structural.Bridge;

public class Sony implements TVset {
    String name;

    public Sony(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void on() {
        System.out.println("Sony on");
    }

    @Override
    public void off() {
        System.out.println("Sony off");
    }

    @Override
    public void tuneChannel() {
        System.out.println("Channel tunes...");
    }
}
