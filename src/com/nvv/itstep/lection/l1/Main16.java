package com.nvv.itstep.lection.l1;

public class Main16 {
    public static void main(String[] args) {
        int[][] container = new int[3][];
        container[0] = new int[]{6, 6, 6};
        container[1] = new int[]{6, 6, 6, 7, 7};
        int[] temp = {1, 1, 1, 1, 1, 1, 1, 1};
        container[2] = temp;

        //int[][] container = {{1, 3}, {7, 8}, {1, 1, 1, 1}};
        //System.out.println(container.length);

        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container[i].length; j++) {
                System.out.print(container[i][j] + " ");
            }
            System.out.println();
        }
    }
}
