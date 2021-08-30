package com.nvv.itstep.hw.d15072021;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

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

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Укажите количество рядов > ");
        int n = in.nextInt();
        System.out.print("Укажите количество мест в ряде > ");
        int m = in.nextInt();

        if (n > 0 && m > 0) {

            int freePlaces = n * m;
            int unfreePlaces = 0;

            Random rand = new Random();

            int[][] places = new int[n][m];

            for (int i = 0; i < places.length; i++) {
                for (int j = 0; j < places[i].length; j++) {
                    places[i][j] = (rand.nextInt(n + m) % 2);
                    if (places[i][j] == 1) {
                        unfreePlaces++;
                    }
                }
            }
            for(int arr[] : places){
                System.out.println(Arrays.toString(arr));
            }

            freePlaces -= unfreePlaces;

            System.out.print("Укажите количество мест в запросе, или количество соседних мест в одном ряду > ");
            int k = in.nextInt();

            if (freePlaces >= k && k >= 1) { // если свободных мест больше или равно мест по запросу или одно

                boolean findOne = false; // флаг - есть что ответить запросу
                for (int i = 0; i < places.length; i++) { // просмотр по рядам
                    for (int j = 0; j < places[i].length; j++) { // просмотр по местам
                        if (places[i][j] == 0) { // есть одно свободное место
                            int findCountFreePlaces = k - 1; // счетчик
                            for (int t = j + 1; t < places[i].length && findCountFreePlaces > 0; findCountFreePlaces--, t++) { // проверяем есть ли требуемое количество свободных мест
                                if (places[i][t] == 1) {
                                    break;
                                }
                            }
                            if (findCountFreePlaces == 0) { // счетчик занулился - значит есть требуемое количество свободных мест
                                int row = i + 1; // ряд
                                int tmpPlaces = i * places[j].length; // нужно для определения номера места
                                int freeFromPlace = tmpPlaces + j + 1; // свободное место  - начало
                                int freeToPlace = tmpPlaces + j + k; // свободное место конец
                                if(k == 1){ // если запрос был только на одно место - как вариант
                                    System.out.println("Вариант : ряд -" + row + " место: " + freeFromPlace );
                                }
                                else{
                                    System.out.println("Вариант : ряд -" + row + " места: с " + freeFromPlace + " по " + freeToPlace);
                                }
                                findOne = true; // поднимем флаг
                            }
                        }
                    }
                }
                if(findOne == false){
                    System.out.print("Отсутствует результат удовлетворяющий запрос....");
                }
            }
            else{
                System.out.print("Отсутствует результат удовлетворяющий запрос....");
            }
        }
        else {
            System.out.print("Error data ...");
        }


        in.close();
    }
}
