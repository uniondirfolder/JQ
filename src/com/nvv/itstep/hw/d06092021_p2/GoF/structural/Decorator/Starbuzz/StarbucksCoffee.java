package com.nvv.itstep.hw.d06092021_p2.GoF.structural.Decorator.Starbuzz;

public class StarbucksCoffee {
    public static void main(String[] args) {
        Coffee coffee = new Sugar(new Milk(new DarkCoffee(Size.VENTS)));

//        System.out.println(coffee.getName() + ": " + coffee.cost() + " $.");
        System.out.printf("%s: %.2f $.", coffee.getName(), coffee.cost());
    }
}
