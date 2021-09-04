package com.nvv.itstep.hw.d06092021_p2.GoF.creational.FactoryMethod.PizzaStyle;

public class Program {
    public static void main(String[] args) {
        FactoryMethod factoryMethod = new MinPizzaFactory();
        Pizza pizza = factoryMethod.preparePizza("cheese");
        pizza.createPizza();
        
        factoryMethod = new VitPizzaFactory();
        pizza = factoryMethod.preparePizza("veggie");
        pizza.createPizza();
    }
}
