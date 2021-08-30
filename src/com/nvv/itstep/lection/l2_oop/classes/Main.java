package com.nvv.itstep.lection.l2_oop.classes;

//alt + 1 - переместить курсор в структуру проекта
public class Main {//alt + insert - создать класс

    public static void main(String[] args) {
        int age = 18;
        User user1 = new User();//shift + F6 - переименовать
        user1.firstName = "Ivan";
        user1.secondName = "Ivanov";
        if (age > 0) {
            user1.age = age;
        }
        age = -40;
        User user2 = new User();
        user2.secondName = "Petr";//ctrl, ctrl + down
        user2.firstName = "Petrov";
        if (age > 0) {
            user2.age = age;
        }
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user1 == user2);
        System.out.println(user1.equals(user2));

        int[] arr = new int[3];
        System.out.println(arr.length);
        //arr.length = 4;


    }
}
