package com.nvv.itstep.hw.d20072021.arch.store;


import com.nvv.itstep.hw.d20072021.data.capsula.Developer;
import com.nvv.itstep.hw.d20072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceBuyer {
     void basketAdd(ProductUnit product);
     void basketRemoveGoods(int position);
     void basketClear();
}
