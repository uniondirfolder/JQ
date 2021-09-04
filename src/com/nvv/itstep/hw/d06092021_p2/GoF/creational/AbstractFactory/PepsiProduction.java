package com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory;


import com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory.pepsi.PepsiFactory;

public class PepsiProduction {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = (ProjectTeamFactory) new PepsiFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getProjectManager();
        
        System.out.println("Creating pepsi production");
        
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
