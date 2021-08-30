package com.nvv.itstep.lection.l1;

import java.util.Arrays;

public class Main15 {
    public static void main(String[] args) {
        //двумерный массив
        int[] arr = new int[5];
        System.out.println(Arrays.toString(arr));

        int[][] container = new int[2][3];
        container[0][0] = 1;//ctrl + D
        container[0][1] = 3;
        container[0][2] = 5;
        container[1][0] = 7;
        container[1][1] = 8;
        container[1][2] = 9;
        System.out.println(container);
        System.out.println(container[0]);
        System.out.println(container[1]);

//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(container[i][j] + " ");
//            }
//            System.out.println();
//        }

//        for (int[] array : container) {//shift + F6
//            for (int value : array) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }

        //System.out.println(Arrays.toString(container));
//        for (int[] array : container) {
//            System.out.println(Arrays.toString(array));
//        }

    }
}
