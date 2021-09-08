package itstep.hw.d19072021.arch.store;


import itstep.hw.d19072021.data.capsula.Developer;
import itstep.hw.d19072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceBuyer {
     void basketAdd(ProductUnit product);
     void basketRemoveGoods(int position);
     void basketClear();
}
