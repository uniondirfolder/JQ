package com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory.banking;


import com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory.ProjectManager;

public class BankingPM implements ProjectManager {

    @Override
    public void manageProject() {
        System.out.println("Banking PM manage banking project");
    }
}
