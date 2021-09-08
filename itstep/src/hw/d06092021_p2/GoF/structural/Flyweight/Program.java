package hw.d06092021_p2.GoF.structural.Flyweight;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        DeveloperFactory developerFactory = new DeveloperFactory();

        List<Developer> developers = new ArrayList<>();

        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("c++"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));

        for (Developer developer : developers) {
            developer.writeCode();
        }
    }
}
