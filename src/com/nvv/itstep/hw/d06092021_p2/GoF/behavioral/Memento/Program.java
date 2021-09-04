package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.Memento;

public class Program {

    public static void main(String[] args) {
        Project project = new Project();
        Github github = new Github();
        
        System.out.println("Creating new project:");
        project.setVersionAndDate("Version 1.0");
        System.out.println(project);
        System.out.println("Saving current project...");
        github.setSave(project.save());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        project.setVersionAndDate("Version 1.1");
        System.out.println("Updating project to v. 1.1.");
        System.out.println("Writing poor code...");
        System.out.println(project);
        System.out.println("Rolling back to v. 1.0.");
        project.load(github.getSave());
        System.out.println(project);
    }
}
