package com.nvv.itstep.lection.l4_oop2.aggregation;

public class Transmission {
    private int gears;
    private String type;

    public Transmission(int gears, String type) {
        this.gears = gears;
        this.type = type;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "gears=" + gears +
                ", type='" + type + '\'' +
                '}';
    }
}
