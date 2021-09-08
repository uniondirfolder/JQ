package lection.l4_oop2.polymorphism;

public class Rectangle extends Shape{//alt + insert, alt + enter
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

//    @Override
//    public double calcArea() {
//        return width * height;
//    }

    public static void test() {
        System.out.println("Rectangle");
    }
}
