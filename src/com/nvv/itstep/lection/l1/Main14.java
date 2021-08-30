package com.nvv.itstep.lection.l1;

public class Main14 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 7, 7, 7};

        //iter
        for (int value : arr) {
            System.out.print(value + " ");
        }

        for (int value : arr) {
            value *= 2;
        }

        System.out.println();

        for (int value : arr) {
            System.out.print(value + " ");
        }

        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        System.out.println("\n" + sum);
    }
}
