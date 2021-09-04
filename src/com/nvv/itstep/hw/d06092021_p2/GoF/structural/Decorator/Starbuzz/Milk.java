package com.nvv.itstep.hw.d06092021_p2.GoF.structural.Decorator.Starbuzz;

public class Milk extends Decorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getName() {
        return coffee.getName() + ", milk";
    }

    @Override
    public double cost() {
        double cost = coffee.cost();
        if(getSize() == Size.VENTS) {
            cost += (double)0.3;
        } else if(getSize() == Size.GRANDE) {
            cost += 0.2;
        } else if(getSize() == Size.TALL) {
            cost += 0.1;
        }
        cost = Math.round(cost * 100) / 100.0d;
        return cost;
    }
}
