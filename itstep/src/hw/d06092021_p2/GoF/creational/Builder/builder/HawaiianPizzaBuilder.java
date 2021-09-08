package hw.d06092021_p2.GoF.creational.Builder.builder;

public class HawaiianPizzaBuilder extends PizzaBuilder {
    @Override
    public void buildDough() {
        pizza.setDough("HawaiiDough");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("HawaiiSauce");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("HawaiiTopping");
    }
}
