package hw.d01082021;


import hw.d01082021.enums.Countries;
import hw.d01082021.enums.Part;
import hw.d01082021.enums.Sex;
import hw.d01082021.enums.Speciality;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

// Создать arraylist, который хранит как экземпляры класса User, так экземпляры класса Employee
public class DataBase {
    public static ArrayList<Human> getHumans() {
        ArrayList<Human> arraylist = new ArrayList<>();
        Human[] arr = new Human[]{
                new Human("Dan", "Nando", 16, Sex.MAN),
                new Human("Marychka", "Lisova", 25, Sex.WOMAN),
                new Human("Iren", "Hans", 15, Sex.WOMAN),
                new Human("Zac", "Freeman", 30, Sex.MAN),
                new Human("Anna", "Shogova", 24, Sex.WOMAN),
                new Human("Steve", "Amba", 41, Sex.MAN),
                new Human("Lisa", "Bant", 29, Sex.WOMAN),
                new Human("Petro", "Pyatochkin", 28, Sex.MAN),
                new Human("Elza", "Cupperman", 23, Sex.WOMAN),
                new Human("Ork", "Hlork", 23, Sex.MAN),
                new Human("Sila", "Hans", 17, Sex.WOMAN),
                new Human("Ibn", "Aly", 26, Sex.MAN),

        };
        String[] mail = new String[]{
                "@example.com",
                "@gmail.com"
        };
        Speciality[] specialities = Speciality.values();
        Countries[] countries = Countries.values();
        Part[] parts = Part.values();

        final Random random = new Random();

        // Создать arraylist, который хранит как экземпляры класса User, так экземпляры класса Employee
        for (int i = 0; i < 30; i++) {
            Human human = new Human(arr[random.nextInt(arr.length)]);
            String country = countries[random.nextInt(countries.length )].toString();
            User user = new User(new Human(human), human.getFirstName().toLowerCase(Locale.ROOT) + human.getAge() + mail[random.nextInt(mail.length)], country);
            Employee employee = new Employee(user, random.nextInt(50000) + 20000, specialities[random.nextInt(specialities.length)], parts[random.nextInt(parts.length)].toString());

            if (i % 2 == 0) {
                arraylist.add(user); // экземпляры класса User
            }
            else{
                if(employee.getProfession() == Speciality.TESTER){
                    String m = "test" + mail[random.nextInt(mail.length)];
                    employee.setEmail(m);
                }
                arraylist.add(employee); // экземпляры класса Employee
            }
        }

        return arraylist;
    }
}
