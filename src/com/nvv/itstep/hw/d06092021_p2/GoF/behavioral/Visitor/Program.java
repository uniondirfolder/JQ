package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.Visitor;

public class Program {

    public static void main(String[] args) {
        Project project = new Project();
        Developer junior = new Junior();
        Developer senior = new Senior();

        System.out.println("Junior in action...");
        project.beWritten(junior);

        System.out.println("==============================");

        System.out.println("Senior in action...");
        project.beWritten(senior);
    }
}
