package hw.d06092021_p2.GoF.creational.AbstractFactory.banking;


import hw.d06092021_p2.GoF.creational.AbstractFactory.Developer;
import hw.d06092021_p2.GoF.creational.AbstractFactory.ProjectManager;
import hw.d06092021_p2.GoF.creational.AbstractFactory.ProjectTeamFactory;
import hw.d06092021_p2.GoF.creational.AbstractFactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {

    @Override
    public Developer getDeveloper() {
        return (Developer) new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return (Tester) new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
