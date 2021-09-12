package hw.d06092021_p2.GoF.creational.FactoryMethod.Pizza;

public class VeggiPizzaFactory implements FactoryMethod {

    @Override
    public Pizza preparePizza() {
        return new VeggiePizza();
    }
}
