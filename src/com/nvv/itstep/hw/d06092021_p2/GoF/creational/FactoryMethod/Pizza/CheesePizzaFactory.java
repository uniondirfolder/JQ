package com.nvv.itstep.hw.d06092021_p2.GoF.creational.FactoryMethod.Pizza;

public class CheesePizzaFactory implements FactoryMethod {

    @Override
    public Pizza preparePizza() {
        return new CheesePizza();
    }
}
