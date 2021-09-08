package lection.l3_inherintance.technics;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(
                "m1",
                1000,
                1,
                1000,
                1);
        Computer computer1 = new Computer(
                "m2",
                2000,
                2);

        Computer[] computers = new Computer[4];
        computers[0] = laptop1;
        computers[1] = computer1;
        computers[2] = new Computer(
                "m2", 3000, 6);
        System.out.println(Arrays.toString(computers));

//        Object[] objects = new Object[6];
//        objects[0] = laptop1;
//        objects[1] = "Hello";
//        objects[2] = 3;



    }
}
