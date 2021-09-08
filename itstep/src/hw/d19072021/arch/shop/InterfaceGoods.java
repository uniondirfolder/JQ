package hw.d19072021.arch.shop;


import hw.d19072021.data.capsula.Developer;
import hw.d19072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceGoods {
    void productUnitAddItem(ProductUnit productUnit);
    ProductUnit[] productUnitGetItems();
    void removeItem(int position);
    void clear();
}
