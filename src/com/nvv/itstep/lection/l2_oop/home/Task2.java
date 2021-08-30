package com.nvv.itstep.lection.l2_oop.home;

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        /*2.В кинотеатре n рядов по m мест в каждом (m и n должно
                задаваться с клавиатуры). В двумерном массиве размерностью m на n хранится информация о проданных билетах.
                Число 1 означает, что билет на данное место уже продан,
        число 0 означает, что место свободно. Поступил запрос на
        продажу k билетов на соседние места в одном ряду (k должно
                задаваться с клавиатуры).
                Определите, можно ли выполнить такой запрос. Если решения есть, вывести номера рядов и номера свободных мест
        для продажи.
        Число занятых мест и какие места заняты на момент запроса определите случайным образом.
                Вывести исходный массив на экран.*/

        Scanner in = new Scanner(System.in);

        System.out.print("Enter count of rows: ");
        int rows = in.nextInt();
        System.out.print("Enter count of seats in one row: ");
        int columns = in.nextInt();

        byte[][] matrix = CreateMatrix(rows, columns);

        System.out.print("Enter count tickets to buy: ");
        int countTickets = in.nextInt();

        ShowAvailableSeats(matrix, countTickets);

        System.out.println("\n\t\t\tAll Seats:");
        ShowMatrix(matrix);
    }

    public static byte[][] CreateMatrix(int rows, int columns) {
        byte[][] matrix = new byte[rows][columns];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (byte)rand.nextInt(2);
            }
        }
        return matrix;
    }

    public  static void ShowMatrix(byte[][] matrix) {
        for (byte[] arr : matrix) {
            for (byte item : arr) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void ShowAvailableSeats(byte[][] matrix, int countSeats) {
        int currentRow = 0;
        boolean isAvailable = false;

        System.out.println("\nFree seats:");

        for (byte[] row : matrix) {
            currentRow++;

            if (row.length < countSeats)
                break;

            int countAvailable = 0;
            for (byte val : row) {
                if (val == 0) countAvailable++;
            }

            if (countAvailable < countSeats) continue;
            isAvailable = true;

            System.out.println("ROW: " + currentRow);
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 0)
                    System.out.print((i + 1) + " ");
            }
            System.out.println();
        }
        if (!isAvailable)
            System.out.println("\t\t\tSorry, not available seats now!");
    }
}
