package com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory.website;


import com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory.ProjectManager;

public class WebsitePM implements ProjectManager {

    @Override
    public void manageProject() {
        System.out.println("Website PM manage website project");
    }
}