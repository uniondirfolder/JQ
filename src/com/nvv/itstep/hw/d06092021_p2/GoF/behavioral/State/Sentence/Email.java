package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.State.Sentence;

public class Email implements State{
    Sentence sentence;

    public Email(Sentence sentence) {
        this.sentence = sentence;
    }

    @Override
    public String getName() {
        return "\'e-mail\'";
    }

    @Override
    public String next() {
        return "space";
    }

    @Override
    public String toString() {
        return "email";
    }
}
