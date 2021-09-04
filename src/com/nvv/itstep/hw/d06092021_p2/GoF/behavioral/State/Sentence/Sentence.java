package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.State.Sentence;

import java.util.ArrayList;

public class Sentence {
    State word;
    State punctMark;
    State sentenceEnd;
    State email;

    State state = word;
    ArrayList<State> states;

    public Sentence() {
        word = new Word(this);
        punctMark = new PunctMark(this);
        sentenceEnd = new SentenceEnd(this);
        email = new Email(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getWord() {
        return word;
    }

    public State getPunctMark() {
        return punctMark;
    }

    public State getSentenceEnd() {
        return sentenceEnd;
    }

    public State getEmail() {
        return email;
    }

    public void getName() {
        state.getName();
    }

    public void next() {
        state.next();
    }
    @Override
    public String toString() {
        return "Sentence [word=" + word + ", punctMark=" + punctMark
                + ", sentenceEnd=" + sentenceEnd + ", email=" + email
                + ", state=" + state + "]";
    }

}
