package lection.l7_cf;


import lection.l7_cf.home.ArrayUser;
import lection.l7_cf.home.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Ivan", "Ivanov",18);
        User user2 = new User("test", "test",20);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");

        ArrayUser arrayUser = new ArrayUser();
        arrayUser.setFirst(user1);
        arrayUser.setFirst(user2);

//        for (String v : arrayUser) {
//            System.out.println(v);
//        }



    }
}
