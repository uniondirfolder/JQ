package hw.d06092021_p2.GoF.creational.Prototype.prototype;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Shape> cache = new ArrayList<>();
        Shape circle = new Circle();
        Shape clonedCircle = circle.clone();
        circle.draw();
        clonedCircle.draw();
        cache.add(circle);
        cache.add(clonedCircle);
        Shape rect = new Rectangle();
        Shape clonedRect = rect.clone();
        rect.draw();
        clonedRect.draw();
        cache.add(rect);
        cache.add(clonedRect);
        if (cache.get(0) != cache.get(1) && circle != clonedCircle) {
            System.out.println("Circle and ClonedCircle references point to different objects");
        }
        if (cache.get(0).equals(cache.get(1)) && circle.equals(clonedCircle)) {
            System.out.println("Objects Circle and ClonedCircle are identical");
        }
        if (cache.get(2) != cache.get(3) && rect != clonedRect) {
            System.out.println("Rectangle and ClonedRectangle references point to different objects");
        }
        if (cache.get(2).equals(cache.get(3)) && rect.equals(clonedRect)) {
            System.out.println("Objects Rectangle and ClonedRectangle are identical");
        }
    }
}
