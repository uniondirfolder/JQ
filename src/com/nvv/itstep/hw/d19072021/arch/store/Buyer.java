package com.nvv.itstep.hw.d19072021.arch.store;


import com.nvv.itstep.hw.d19072021.arch.shop.Basket;
import com.nvv.itstep.hw.d19072021.arch.shop.Customer;
import com.nvv.itstep.hw.d19072021.arch.shop.History;
import com.nvv.itstep.hw.d19072021.data.capsula.Developer;
import com.nvv.itstep.hw.d19072021.data.capsula.ProductUnit;

@Developer
public final class Buyer extends History implements InterfaceBuyer {
    private Basket basket;
    private Customer customer;

    public Buyer(Basket basket, Customer customer, String firstSnapshot) {
        super(firstSnapshot);
        this.basket = basket;
        this.customer = customer;
    }

    public Basket getBasket() {
        return basket;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void basketAdd(ProductUnit product) {
        // ToDo
       basket.basketAddGoods(product);
    }

    @Override
    public void basketRemoveGoods(int position) {
        // ToDo
    }

    @Override
    public void basketClear() {
        // ToDo
    }

    public static Buyer Builder(String name, int age, String firstSnapshot){
        Customer customer = new Customer(null, name, age);
        Basket basket = new Basket(customer);
        customer.setBasket(basket);
        Buyer buyer = new Buyer(basket,customer,firstSnapshot);
        return buyer;
    }
}
