package com.nvv.itstep.hw.d22082021.enums;

import com.nvv.itstep.hw.d22082021.abstracts.Developer;

@Developer
public enum ChipEnum {
    GREEN(1),
    YELLOW(10),
    RED(100);
    public final int val;

    ChipEnum(int val) {
        this.val = val;
    }
}
