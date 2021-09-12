package hw.d06092021_p2.GoF.creational.AbstractFactory.website;


import hw.d06092021_p2.GoF.creational.AbstractFactory.Developer;
import hw.d06092021_p2.GoF.creational.AbstractFactory.ProjectManager;
import hw.d06092021_p2.GoF.creational.AbstractFactory.ProjectTeamFactory;
import hw.d06092021_p2.GoF.creational.AbstractFactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {

    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }
}
