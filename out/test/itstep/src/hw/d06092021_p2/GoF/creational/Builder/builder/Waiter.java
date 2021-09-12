package hw.d06092021_p2.GoF.creational.Builder.builder;

/**
 * Director.
 */
public class Waiter {
    private PizzaBuilder builder;

    public void makeOrder(PizzaBuilder builder) {
        this.builder = builder;
    }

    public Pizza bringPizza() {
        return builder.getPizza();
    }

    public void preparePizza() {
        builder.createNewPizza();
        builder.buildDough();
        builder.buildSauce();
        builder.buildTopping();
    }
}
