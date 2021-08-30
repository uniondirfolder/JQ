package com.nvv.itstep.hw.d20072021.arch.store;


import com.nvv.itstep.hw.d20072021.data.capsula.Developer;
import com.nvv.itstep.hw.d20072021.data.capsula.ProductUnit;
@Developer
public interface InterfaceSailor {
     void goodsAdd(ProductUnit productUnit);
     ProductUnit[] goodsGet();
}
