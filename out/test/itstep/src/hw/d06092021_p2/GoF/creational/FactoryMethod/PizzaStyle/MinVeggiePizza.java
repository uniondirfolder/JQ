package hw.d06092021_p2.GoF.creational.FactoryMethod.PizzaStyle;

public class MinVeggiePizza implements Pizza {

    @Override
    public void createPizza() {
        System.out.println("Create Minsk style veggie pizza");
    }
}
