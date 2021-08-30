package com.nvv.itstep.hw.d15072021;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /*
    1.Заполните n-мерный квадратный массив возрастающими
    числами – змейкой. Выведите результат на экран с соблюдением ширины столбцов
    Пример:
    1 2 3 4
    8 7 6 5
    9 10 11 12
    16 15 14 13

    * */

    public static void main(String[] args) {


        // Task 1
        int[][] container = new int[12][7];

        for (int i = 0, num = 0; i < container.length; i++) {
            if (i % 2 == 0) {
                for (int k = 0; k < container[i].length; k++) {
                    container[i][k] = ++num;
                }
            } else {
                for (int j = container[i].length - 1; j >= 0; j--) {
                    container[i][j] = ++num;
                }
            }
        }

        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container[i].length; j++) {
                System.out.print(String.format("%-5d", container[i][j]));
            }
            System.out.print("\n");
        }

    }
}
