package com.nvv.itstep.hw.d20072021.test;

public class Parent{
    private int secret=10;

    public Parent(int secret) {
        this.secret = secret;
    }

    public Parent(Parent p) {
        this.secret = p.secret+10;
    }

    public int getSecret() {
        return secret;
    }
}
