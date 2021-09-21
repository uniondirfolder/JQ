package com.nvv.implts;

import com.nvv.abstrcts.AbstractRepository;


public class PocketLeft extends AbstractRepository {
    @Override
    public void create(Object object) {
        System.out.println("pocketLeft: " + "public void create(Object object)");
    }

    @Override
    public Object read(Object object) {
        System.out.println("pocketLeft: " + "public Object read(Object object)");
        return null;
    }

    @Override
    public void update(Object object) {
        System.out.println("pocketLeft: " + "public void update(Object object)");
    }

    @Override
    public void delete(Object object) {
        System.out.println("pocketLeft: " + "public void delete(Object object)");
    }
}
