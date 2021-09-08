package hw.d06092021_p2.GoF.creational.Prototype.prototype;

import java.util.Objects;

public class Circle extends Shape {
    private int radius;

    public Circle() {
        radius = 10;
    }

    @Override
    public void draw() {
        System.out.println("Circle with radius: " + radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
