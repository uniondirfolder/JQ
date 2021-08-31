package com.nvv.itstep.lection.l16_clone;

public class Main {
    public static void main(String[] args) {
        //метод clone
        User original = new User("Ivan", 18, new Address("Viniza","15"));
        System.out.println(original);

        try {
            User copy = original.clone();
            copy.setAge(33);
            copy.setLogin("Petr");
            copy.getAddress().setHomeNumber("88");

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(original);

    }
}
