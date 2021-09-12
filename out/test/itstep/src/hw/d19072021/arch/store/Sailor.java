package hw.d19072021.arch.store;


import hw.d19072021.arch.shop.Goods;
import hw.d19072021.data.capsula.Developer;
import hw.d19072021.data.capsula.ProductUnit;

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
