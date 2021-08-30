package com.nvv.itstep.lection.l8_stream_api.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(15);
//        integers.add(3);
//        integers.add(33);
//        integers.add(8);
//        integers.add(25);
//        System.out.println(integers);
//        Collections.sort(integers);
//        System.out.println(integers);

//        ArrayList<String> numbers = new ArrayList<>();
//        numbers.add("one");
//        numbers.add("two");
//        numbers.add("three");
//        numbers.add("four");
//        numbers.add("five");
//        numbers.add("eleven");
//        System.out.println(numbers);
//        Collections.sort(numbers);
//        System.out.println(numbers);

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Ivan", "Ivanov", 18));
        people.add(new Person("Aaa", "Bbb", 30));
        people.add(new Person("Test", "Testovich", 13));
        people.add(new Person("Bob", "Marley", 60));

        people.forEach(System.out::println);

        Collections.sort(people);
        System.out.println();
        people.forEach(System.out::println);

        people.sort(new PersonAgeComparator());
        System.out.println();
        people.forEach(System.out::println);


        people.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));

    }
}
