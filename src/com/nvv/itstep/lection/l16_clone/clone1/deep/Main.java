package com.nvv.itstep.lection.l16_clone.clone1.deep;

public class Main {
    public static void main(String[] args) {
        //констуктор копирования
        Address address = new Address("Lenina", "102a");
        User original = new User("Ivan", 18, address);
        System.out.println(original);
        //User copy = original;
        User copy = new User(original);
        copy.setAge(33);
        copy.setLogin("Petr");
        copy.getAddress().setHomeNumber("333b");

        System.out.println(original);

    }
}
