package com.nvv.itstep.hw.d19072021.arch.store;


import com.nvv.itstep.hw.d19072021.arch.shop.Goods;
import com.nvv.itstep.hw.d19072021.data.capsula.Developer;
import com.nvv.itstep.hw.d19072021.data.capsula.ProductUnit;

@Developer
public final class Sailor implements InterfaceSailor {
    private Goods goods = new Goods();


    @Override
    public void goodsAdd(ProductUnit productUnit) {
        goods.productUnitAddItem(productUnit);
    }

    @Override
    public ProductUnit[] goodsGet() {
        return goods.productUnitGetItems();
    }

}
