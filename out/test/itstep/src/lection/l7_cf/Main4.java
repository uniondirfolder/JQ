package lection.l7_cf;

import java.util.ArrayList;

public class Main4 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(10);
        integers.add(111);
        integers.add(222);
        integers.add(333);
        integers.add(444);
        integers.add(555);
        integers.add(666);
        //integers.add(333);
        //List.of(1, 2, 3);

        integers.add(0, 9);

        System.out.println(integers.lastIndexOf(333));
    }
}
