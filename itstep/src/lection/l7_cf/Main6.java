package lection.l7_cf;

import java.util.*;

public class Main6 {
    public static void main(String[] args) {
//        List<Integer> numbers = new ArrayList<>();
//        long l1 = System.currentTimeMillis();
//        for (int i = 0; i < 100_000; i++) {
//            numbers.add(0, 1);
//        }
//        long l2 = System.currentTimeMillis();
//        System.out.println(l2 - l1);//2426


//        LinkedList<Integer> numbers = new LinkedList<>();
//        long l1 = System.currentTimeMillis();
//        for (int i = 0; i < 100_000; i++) {
//            numbers.addFirst(1);
//        }
//        long l2 = System.currentTimeMillis();
//        System.out.println(l2 - l1);//24



        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            numbers.addFirst(1);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);//11


    }
}
