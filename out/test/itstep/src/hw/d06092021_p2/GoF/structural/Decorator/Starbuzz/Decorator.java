package hw.d06092021_p2.GoF.structural.Decorator.Starbuzz;

public abstract class Decorator implements Coffee {
    Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public Size getSize() {
        return coffee.getSize();
    };

    @Override
    public abstract String getName();

    @Override
    public abstract double cost();
}
