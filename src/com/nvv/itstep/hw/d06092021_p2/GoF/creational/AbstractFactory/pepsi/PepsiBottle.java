package com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory.pepsi;


import com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory.Developer;

public class PepsiBottle implements Developer {

    @Override
    public void writeCode() {
        System.out.println("Create pepsi bottle");
    }
}