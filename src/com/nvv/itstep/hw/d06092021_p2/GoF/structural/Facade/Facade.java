package com.nvv.itstep.hw.d06092021_p2.GoF.structural.Facade;

public class Facade {
    Job job = new Job();
    BugTracker bugTracker = new BugTracker();
    Developer developer = new Developer();

    public void solvingProblem() {
        job.doJob();
        bugTracker.startingSprint();
        developer.doJobBeforeDeadline(bugTracker);
    }

    public void relaxTime() {
        bugTracker.finishSprint();
        developer.doJobBeforeDeadline(bugTracker);
    }
}
