package lection.l7_cf;

import java.util.LinkedList;

public class Main5 {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(111);
        integers.add(222);
        integers.add(333);
        integers.add(444);
        integers.add(555);
        integers.add(666);
        //integers.add(333);
        //List.of(1, 2, 3);

        integers.add(0, 9);
        integers.addFirst(2);
        integers.offerFirst(2);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        System.out.println(integers.lastIndexOf(333));
    }
}
