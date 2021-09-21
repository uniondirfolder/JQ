package com.nvv.implts;

import com.nvv.abstrcts.AbstractRepository;

public class PocketRight extends AbstractRepository {
    @Override
    public void create(Object object) {
        System.out.println("pocketRight: " + "public void create(Object object)");
    }

    @Override
    public Object read(Object object) {
        System.out.println("pocketRight: " + "public Object read(Object object)");
        return null;
    }

    @Override
    public void update(Object object) {
        System.out.println("pocketRight: " + "public void update(Object object)");
    }

    @Override
    public void delete(Object object) {
        System.out.println("pocketRight: " + "public void delete(Object object)");
    }
}
