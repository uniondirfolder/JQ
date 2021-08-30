package com.nvv.itstep.lection.l8_l9_stream_api.generic;

public class Passport<T> {
    private T number;

    public Passport(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Password{" +
                "number='" + number + '\'' +
                '}';
    }
}
