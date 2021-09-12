package hw.d06092021_p2.GoF.creational.FactoryMethod.PizzaStyle;

public class MinPizzaFactory implements FactoryMethod {

    @Override
    public Pizza preparePizza(String name) {
        switch (name) {
        case "cheese":
            return new MinCheesePizza();
        case "veggie":
            return new MinVeggiePizza();
        default:
            return null;
        }
    }
}
