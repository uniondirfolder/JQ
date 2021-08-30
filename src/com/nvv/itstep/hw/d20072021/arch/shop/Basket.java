package com.nvv.itstep.hw.d20072021.arch.shop;


import com.nvv.itstep.hw.d20072021.data.capsula.Developer;
import com.nvv.itstep.hw.d20072021.data.capsula.ProductUnit;
@Developer
public final class Basket implements InterfaceBasket {

    private  Customer customer;
    private  Goods goods = new Goods();
    private ProductUnit currentView;

    public  Basket(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Customer basketGetCustomer() {
        return customer.getCustomer();
    }

    @Override
    public ProductUnit[] basketGetGoods() {
        return this.goods.productUnitGetItems();
    }

    @Override
    public void basketAddGoods(ProductUnit productUnit) {
        goods.add(productUnit);
    }


    public ProductUnit getCurrentView() {
        return currentView;
    }

    public void setCurrentView(ProductUnit currentView) {
        this.currentView = currentView;
    }
}
