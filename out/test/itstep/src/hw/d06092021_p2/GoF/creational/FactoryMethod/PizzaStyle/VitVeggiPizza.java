package hw.d06092021_p2.GoF.creational.FactoryMethod.PizzaStyle;

public class VitVeggiPizza implements Pizza {

    @Override
    public void createPizza() {
        System.out.println("Create UA style veggie pizza");
    }
}
