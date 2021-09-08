package itstep.hw.d20072021.arch.store;


import itstep.hw.d20072021.data.capsula.Developer;
import itstep.hw.d20072021.data.capsula.ProductUnit;
@Developer
public interface InterfaceSailor {
     void goodsAdd(ProductUnit productUnit);
     ProductUnit[] goodsGet();
}
