package lection.l8_l9_stream_api.streamapi;

//import ref.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");
        numbers.add("five");

//        Iterator<String> iterator = numbers.iterator();
//        while (iterator.hasNext()) {
//            String number = iterator.next();
//            System.out.println(number);
//        }

//        for (String number : numbers) {
//            System.out.println(number);
//        }

        //numbers.forEach(v-> System.out.println(v));
        numbers.forEach(System.out::println);
        //numbers.forEach(v-> System.out.println(v.toUpperCase()));


//        ArrayList<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(1);
//        numbers.add(1);
//        System.out.println(numbers);
//        for (int number : numbers) {
//            number++;
//        }
//        System.out.println(numbers);

//        ArrayList<User> users = new ArrayList<>();
//        users.add(new User("Ivan"));
//        users.add(new User("Ivan"));
//        users.add(new User("Ivan"));
//
//        ArrayList<User> cloneUsers = new ArrayList<>();
//        for (User user : users) {
//            cloneUsers.add(new User(user));
//        }
//
//
//
//        System.out.println(users);
//        for (User user : users) {
//            user.setFirstName(user.getFirstName() + "!!!");
//        }
//        System.out.println(users);
//
//        System.out.println(cloneUsers);



    }
}
