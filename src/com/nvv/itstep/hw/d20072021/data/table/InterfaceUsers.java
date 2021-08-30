package com.nvv.itstep.hw.d20072021.data.table;


import com.nvv.itstep.hw.d20072021.data.capsula.Developer;
import com.nvv.itstep.hw.d20072021.data.capsula.User;

@Developer
public interface InterfaceUsers {
    public User userGet(int index);

    public User userGetFirst();
    public User userGetLast();
    public User[] userGetAll();
}