package com.nvv.itstep.hw.d22082021.game;


import com.nvv.itstep.hw.d22082021.abstracts.Developer;
import com.nvv.itstep.hw.d22082021.enums.ChipEnum;
import com.nvv.itstep.hw.d22082021.pool.ProgramObject;

@Developer
public final class Chip extends ProgramObject {
    public final ChipEnum property;

    public Chip(ChipEnum property) {
        this.property = property;
    }

    public long getId(){
        return super.id;
    }
}
