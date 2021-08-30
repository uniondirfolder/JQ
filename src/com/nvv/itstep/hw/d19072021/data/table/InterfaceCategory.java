package com.nvv.itstep.hw.d19072021.data.table;


import com.nvv.itstep.hw.d19072021.data.capsula.Category;
import com.nvv.itstep.hw.d19072021.data.capsula.Developer;

@Developer
public interface InterfaceCategory {
     Category categoryGet(int index);
     Category categoryGetRef(Category category);
     Category[] categoryGetAll();
     boolean isCategoryUnique(Category category);
     boolean categoryAdd(Category category);

}
