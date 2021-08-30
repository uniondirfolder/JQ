package com.nvv.itstep.hw.d20072021.arch.store;


import com.nvv.itstep.hw.d20072021.arch.place.CatalogCursor;
import com.nvv.itstep.hw.d20072021.arch.shop.Goods;
import com.nvv.itstep.hw.d20072021.data.capsula.Developer;
import com.nvv.itstep.hw.d20072021.data.capsula.ProductUnit;
@Developer
public final class Sailor implements InterfaceSailor {
    private CatalogCursor position = new CatalogCursor();
    private Goods goods = new Goods();
    private int id= -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void goodsAdd(ProductUnit productUnit)
    {
        productUnit.setId(goods.getCount());
        goods.productUnitAddItem(productUnit);
    }

    @Override
    public ProductUnit[] goodsGet() {
        return goods.productUnitGetItems();
    }

}
