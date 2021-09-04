package com.nvv.itstep.hw.d06092021_p2.GoF.creational.Builder.Traveling;

public class Voucher {
    private String name;
    private Type type;
    private Transport transport;
    private Meals meals;
    private int price;
    
    public Voucher() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Meals getMeals() {
        return meals;
    }

    public void setMeals(Meals meals) {
        this.meals = meals;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return (name + " " + type + " " + transport + " " + meals + " " + price);
    }
}
