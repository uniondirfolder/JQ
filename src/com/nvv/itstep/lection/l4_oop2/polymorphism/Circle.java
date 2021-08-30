package com.nvv.itstep.lection.l4_oop2.polymorphism;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

//    @Override
//    public double calcArea() {
//        return Math.PI * Math.pow(radius, 2);
//    }
}
