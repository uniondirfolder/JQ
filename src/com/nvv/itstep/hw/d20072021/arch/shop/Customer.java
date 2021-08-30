package com.nvv.itstep.hw.d20072021.arch.shop;


import com.nvv.itstep.hw.d20072021.data.capsula.Developer;
import com.nvv.itstep.hw.d20072021.data.capsula.User;

@Developer
public final class Customer extends User implements InterfaceCustomer {
    private  Basket basket;

    public Customer(Basket basket, String name, int age) {
        super(name, age);
        this.basket = basket;
    }


    @Override
    public Customer getCustomer() {
        if(basket == null) return null;
        return basket.basketGetCustomer();
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Basket getBasket() {
        return basket;
    }
}
