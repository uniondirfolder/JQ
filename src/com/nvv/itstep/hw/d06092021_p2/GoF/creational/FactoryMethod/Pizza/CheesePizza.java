package com.nvv.itstep.hw.d06092021_p2.GoF.creational.FactoryMethod.Pizza;

public class CheesePizza implements Pizza {

    @Override
    public void createPizza() {
        System.out.println("Create cheese pizza");
    }
}
