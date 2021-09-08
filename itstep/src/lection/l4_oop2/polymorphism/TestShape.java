package lection.l4_oop2.polymorphism;

public class TestShape {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("green", 2, 4);

        Shape[] shapes = new Shape[6];
        shapes[0] = rectangle;
        shapes[1] = new Rectangle("gold", 3, 3);
        shapes[2] = new Rectangle("white", 5, 5);
        shapes[3] = new Rectangle("red", 6, 6);
        shapes[4] = new Circle("black", 7);
        shapes[5] = new Circle("yellow", 3);

        double sumArea = 0;
        for (Shape shape : shapes) {
            //shape.test();
            sumArea += shape.calcArea();
            System.out.println(shape.calcArea());
        }
        System.out.println();
        System.out.println(sumArea);

        //rectangle.test();
    }

}
