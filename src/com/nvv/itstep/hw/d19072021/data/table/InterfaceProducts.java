package com.nvv.itstep.hw.d19072021.data.table;


import com.nvv.itstep.hw.d19072021.data.capsula.Developer;
import com.nvv.itstep.hw.d19072021.data.capsula.ProductUnit;

@Developer
public interface InterfaceProducts {
     ProductUnit productGet(int index);

     ProductUnit[] userGetAll();
}
