package com.nvv.itstep.hw.d06092021_p2.GoF.creational.AbstractFactory;

public interface ProjectTeamFactory {
    Developer getDeveloper();
    Tester getTester();
    ProjectManager getProjectManager();
}
