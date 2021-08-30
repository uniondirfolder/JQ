package com.nvv.itstep.hw.d20072021.arch.shop;


import com.nvv.itstep.hw.d20072021.data.capsula.Developer;
import com.nvv.itstep.hw.d20072021.data.capsula.Product;
import com.nvv.itstep.hw.d20072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceBasket {
     Customer basketGetCustomer();
     Product[] basketGetGoods();
     void basketAddGoods(ProductUnit productUnit);

}
