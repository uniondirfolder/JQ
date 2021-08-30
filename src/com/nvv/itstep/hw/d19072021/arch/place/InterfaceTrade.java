package com.nvv.itstep.hw.d19072021.arch.place;

import com.nvv.itstep.hw.d19072021.data.capsula.Developer;

@Developer
public interface InterfaceTrade {
    void tradeAddBuyer(String name, int age, String firstSnapshot);
    void tradeAddSailor(String name, int age, String firstSnapshot);
    void tradeAddCatalogProduct(String productName, float price, String description, String categoryName);
}
