package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.State.Sentence;

public class SentenceEnd implements State {
    Sentence sentence;

    public SentenceEnd(Sentence sentence) {
        this.sentence = sentence;
    }

    @Override
    public String getName() {
        return "\'Sentence end\'";
    }

    @Override
    public String next() {
        return "enter";
    }

    @Override
    public String toString() {
        return "sentence end";
    }
}
