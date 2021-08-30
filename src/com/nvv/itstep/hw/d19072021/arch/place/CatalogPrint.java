package com.nvv.itstep.hw.d19072021.arch.place;


import com.nvv.itstep.hw.d19072021.arch.store.Buyer;
import com.nvv.itstep.hw.d19072021.data.capsula.Developer;

@Developer
public interface CatalogPrint {
    void printCategory(Buyer buyer);
    void printCategoryProducts(int position, Buyer buyer);
    void printProductDescription(int position, Buyer buyer);
    void printBasket(Buyer buyer);
}
