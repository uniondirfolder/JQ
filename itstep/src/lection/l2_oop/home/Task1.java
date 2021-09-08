package lection.l2_oop.home;

import java.util.Scanner;

public class Task1 {

    /*1.Заполните n-мерный квадратный массив возрастающими
    числами – змейкой. Выведите результат на экран с соблюдением ширины столбцов
    Пример:
            1 2 3 4
            8 7 6 5
            9 10 11 12
            16 15 14 13*/

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size of matrix: ");
        int num = in.nextInt();

        int[][] myArr = CreateMatrixBySnake(num);
        ShowMatrix(myArr);
        in.close();
    }

    public  static  int[][] CreateMatrixBySnake(int size) {
        int[][] arr = new int[size][size];
        int num = 1;
        int helper = size - 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i % 2 == 0) {
                    arr[i][j] = num;
                } else {
                    arr[i][helper--] = num;
                }
                num++;
            }
            helper = size - 1;
        }
        return arr;
    }
    public  static void ShowMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int item : arr) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
