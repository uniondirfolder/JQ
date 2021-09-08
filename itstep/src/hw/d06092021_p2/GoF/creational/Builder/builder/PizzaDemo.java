package hw.d06092021_p2.GoF.creational.Builder.builder;

public class PizzaDemo {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.makeOrder(new HawaiianPizzaBuilder());
        waiter.preparePizza();
        Pizza pizza = waiter.bringPizza();
        System.out.println("Your pizza: " + pizza.getDough() + ", " + pizza.getSauce() + ", " + pizza.getTopping());
        waiter.makeOrder(new PepperoniPizzaBuilder());
        waiter.preparePizza();
        pizza = waiter.bringPizza();
        System.out.println("Your pizza: " + pizza.getDough() + ", " + pizza.getSauce() + ", " + pizza.getTopping());
    }
}
