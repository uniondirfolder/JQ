package com.nvv.itstep.lection.l3_inherintance.technics;

public class Main1 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Laptop laptop = new Laptop();
        System.out.println(laptop.getModel());

        Computer computer1 = new Computer(
                "LG", 2000, 4);
        Laptop laptop1 = new Laptop(
                "CHina",
                2000,
                7,
                5000,
                2
        );

        //computer.info();

        System.out.println(computer);
        System.out.println(computer1.toString());
        System.out.println(laptop);
        System.out.println(laptop1.toString());

        System.out.println(laptop.getCpuFrequency());
        laptop.overclock(33);
        System.out.println(laptop.getCpuFrequency());
    }
}
