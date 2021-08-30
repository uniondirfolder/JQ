package com.nvv.itstep.hw.d19072021.arch.store;


import com.nvv.itstep.hw.d19072021.data.capsula.Developer;
import com.nvv.itstep.hw.d19072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceSailor {
     void goodsAdd(ProductUnit productUnit);
     ProductUnit[] goodsGet();
}
