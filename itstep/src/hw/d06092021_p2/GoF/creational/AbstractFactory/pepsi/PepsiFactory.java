package hw.d06092021_p2.GoF.creational.AbstractFactory.pepsi;


import hw.d06092021_p2.GoF.creational.AbstractFactory.Developer;
import hw.d06092021_p2.GoF.creational.AbstractFactory.ProjectManager;
import hw.d06092021_p2.GoF.creational.AbstractFactory.ProjectTeamFactory;
import hw.d06092021_p2.GoF.creational.AbstractFactory.Tester;

public class PepsiFactory implements ProjectTeamFactory {

    @Override
    public Developer getDeveloper() {
        return new PepsiBottle();
    }

    @Override
    public Tester getTester() {
        return (Tester) new PepsiLabel();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new PepsiCap();
    }
}
