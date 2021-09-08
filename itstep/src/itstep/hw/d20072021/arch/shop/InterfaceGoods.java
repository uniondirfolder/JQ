package itstep.hw.d20072021.arch.shop;


import itstep.hw.d20072021.data.capsula.Developer;
import itstep.hw.d20072021.data.capsula.ProductUnit;
@Developer
public interface InterfaceGoods {
     void productUnitAddItem(ProductUnit productUnit);
     ProductUnit[] productUnitGetItems();
     void removeItem(int position);
     void clear();
}
