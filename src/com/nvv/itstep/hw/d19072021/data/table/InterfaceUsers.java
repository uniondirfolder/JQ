package com.nvv.itstep.hw.d19072021.data.table;


import com.nvv.itstep.hw.d19072021.data.capsula.Developer;
import com.nvv.itstep.hw.d19072021.data.capsula.User;

@Developer
public interface InterfaceUsers {
    User userGet(int index);

    User userGetFirst();
    User userGetLast();
    User[] userGetAll();
}
