package com.nvv.itstep.hw.d22082021.pool;

import com.nvv.itstep.hw.d22082021.abstracts.Developer;

@Developer
public interface PoolInterface {
    boolean add(Object obj);
    Object get(long id);
}
