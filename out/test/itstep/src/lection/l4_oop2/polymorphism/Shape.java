package lection.l4_oop2.polymorphism;

public abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //public abstract double calcArea();
    public double calcArea(){
        return 0;
    }

    public static void test() {
        System.out.println("Shape");

    }
}
