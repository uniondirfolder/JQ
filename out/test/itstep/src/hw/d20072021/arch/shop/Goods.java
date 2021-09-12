package hw.d20072021.arch.shop;

import hw.d20072021.data.capsula.Developer;
import hw.d20072021.data.capsula.ProductUnit;
import hw.d20072021.data.container.AbstractContainer;

@Developer
public final class Goods extends AbstractContainer implements InterfaceGoods {

    public int getCountGoods(){
        return getCount();
    }
    @Override
    public void productUnitAddItem(ProductUnit productUnit) {
        add(productUnit);
    }

    @Override
    public ProductUnit[] productUnitGetItems() {
        int j = super.getCount();
        if (j == 0) return null;

        ProductUnit[] tmp = new ProductUnit[getCount()];
        for (int i = 0; i < j; i++) {
            tmp[i]=(ProductUnit) getRef(i);
        }
        return tmp;
    }

    @Override
    public void removeItem(int position) {
        // ToDo
    }

    @Override
    public void clear() {
        // ToDo
    }
}
