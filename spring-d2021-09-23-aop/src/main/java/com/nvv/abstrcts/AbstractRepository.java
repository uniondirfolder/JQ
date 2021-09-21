package com.nvv.abstrcts;

public abstract class AbstractRepository {
    abstract public void create(Object object);
    abstract public Object read(Object object);
    abstract public void update(Object object);
    abstract public void delete(Object object);
}
