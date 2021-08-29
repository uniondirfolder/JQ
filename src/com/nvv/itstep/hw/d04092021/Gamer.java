package com.nvv.itstep.hw.d04092021;

import java.util.Objects;

public class Gamer {
    private String name;
    private int rightAnswers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(int rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public Gamer(String name, int rightAnswers) {
        this.name = name;
        this.rightAnswers = rightAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gamer)) return false;
        Gamer gamer = (Gamer) o;
        return rightAnswers == gamer.rightAnswers && name.equals(gamer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rightAnswers);
    }
}
