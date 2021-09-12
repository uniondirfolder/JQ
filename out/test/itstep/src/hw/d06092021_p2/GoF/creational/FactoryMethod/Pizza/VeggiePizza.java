package hw.d06092021_p2.GoF.creational.FactoryMethod.Pizza;

public class VeggiePizza implements Pizza {

    @Override
    public void createPizza() {
        System.out.println("Create vegetable pizza");
    }
}
