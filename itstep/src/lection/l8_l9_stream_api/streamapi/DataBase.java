package lection.l8_l9_stream_api.streamapi;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static List<Human> getHumans() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Ivan", 20, Speciality.DEVELOPER));
        humans.add(new Human("Petr", 33, Speciality.DEVELOPER));
        humans.add(new Human("Stepan", 18, Speciality.DESIGNER));
        humans.add(new Human("Viktoria", 40, Speciality.TESTER));
        humans.add(new Human("Olga", 18, Speciality.DESIGNER));
        humans.add(new Human("Artur", 55, Speciality.TESTER));
        humans.add(new Human("Artem", 15, Speciality.DEVELOPER));
        humans.add(new Human("Bob", 77, Speciality.DESIGNER));
        return humans;
    }
}
