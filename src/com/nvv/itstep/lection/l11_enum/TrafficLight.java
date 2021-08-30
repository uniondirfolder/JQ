package com.nvv.itstep.lection.l11_enum;

public class TrafficLight {
  private ColorEnum color;
//
//    public final static int RED = 1;
//    public final static int YELLOW = 2;
//    public final static int GREEN = 3;

    public TrafficLight(ColorEnum color) {
        this.color = color;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }
}
