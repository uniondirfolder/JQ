package com.nvv.itstep.hw.d06092021_p2.GoF.creational.FactoryMethod.Pizza;

public class Program {
    public static void main(String[] args) {
        FactoryMethod factoryMethod = new CheesePizzaFactory();
        Pizza pizza = factoryMethod.preparePizza();
        pizza.createPizza();
        
        factoryMethod = new VeggiPizzaFactory();
        pizza = factoryMethod.preparePizza();
        pizza.createPizza();
    }
}
