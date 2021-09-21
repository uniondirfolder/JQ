package com.nvv.implts;

import com.nvv.interfs.Candy;
import org.springframework.beans.factory.annotation.Value;


public class Candies implements Candy {
    @Value("${candies.name}")
    private String name;
    @Value("${candies.price}")
    private int price;

    public Candies(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Candies() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public int price() {
        return getPrice();
    }

    @Override
    public String name() {
        return getName();
    }

    @Override
    public String toString() {
        return "Candies{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
