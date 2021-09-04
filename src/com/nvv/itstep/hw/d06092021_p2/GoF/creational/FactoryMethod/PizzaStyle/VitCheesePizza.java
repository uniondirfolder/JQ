package com.nvv.itstep.hw.d06092021_p2.GoF.creational.FactoryMethod.PizzaStyle;

public class VitCheesePizza implements Pizza {

    @Override
    public void createPizza() {
        System.out.println("Create UA style cheese pizza");
    }
}
