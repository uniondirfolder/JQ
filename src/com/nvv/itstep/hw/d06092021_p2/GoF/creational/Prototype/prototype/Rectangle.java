package com.nvv.itstep.hw.d06092021_p2.GoF.creational.Prototype.prototype;

import java.util.Objects;

public class Rectangle extends Shape {
    private int height;
    private int weight;

    public Rectangle() {
        height = 6;
        weight = 8;
    }

    @Override
    public void draw() {
        System.out.println("Rectangle with height: " + height + " and weight: " + weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Rectangle rectangle = (Rectangle) o;
        return height == rectangle.height && weight == rectangle.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, weight);
    }
}
