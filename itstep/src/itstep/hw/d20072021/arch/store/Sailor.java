package itstep.hw.d20072021.arch.store;


import itstep.hw.d20072021.arch.place.CatalogCursor;
import itstep.hw.d20072021.arch.shop.Goods;
import itstep.hw.d20072021.data.capsula.Developer;
import itstep.hw.d20072021.data.capsula.ProductUnit;
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
