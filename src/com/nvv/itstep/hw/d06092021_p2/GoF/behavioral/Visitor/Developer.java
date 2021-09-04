package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.Visitor;

public interface Developer {
    void create(ProjectClass projectClass);
    void create(Database database);
    void create(Test test);
}
