package hw.d19072021.arch.store;


import hw.d19072021.data.capsula.Developer;
import hw.d19072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceBuyer {
     void basketAdd(ProductUnit product);
     void basketRemoveGoods(int position);
     void basketClear();
}
