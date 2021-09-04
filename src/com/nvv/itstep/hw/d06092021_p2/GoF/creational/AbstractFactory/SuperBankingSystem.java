package com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory;


import com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory.banking.BankingTeamFactory;

public class SuperBankingSystem {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = (ProjectTeamFactory) new BankingTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getProjectManager();

        System.out.println("Creating super banking system...");

        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
