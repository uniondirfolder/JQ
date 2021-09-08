package hw.d06092021_p2.GoF.creational.AbstractFactory.pepsi;


import itstep.hw.d06092021_p2.GoF.creational.AbstractFactory.ProjectManager;

public class PepsiCap implements ProjectManager {

    @Override
    public void manageProject() {
        System.out.println("Create pepsi cap");
    }
}
