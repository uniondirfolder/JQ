package hw.d01082021;



import hw.d01082021.enums.Countries;
import hw.d01082021.enums.Sex;
import hw.d01082021.enums.Speciality;

import java.util.*;
import java.util.stream.Collectors;

// рандомные данные не всегда видно результат(по некоторым выборкам), со второго запуска точно есть
public class Main {

    public static void main(String[] args) {

        ArrayList<Human> data = DataBase.getHumans();
//без использования StreamAPI:
//сгруппировать людей по специальностям
//в разные коллекции
//заранее не знаем сколько у нас специальностей
//хранить в map(ключ-специальность, значение-список из human)

//печать всех групп

        Map<Speciality, ArrayList<Employee>> map = Employee.Go.getMapHumansByProfession(data);
        map.forEach((speciality, employee) -> {
            System.out.println(speciality);
            employee.forEach(System.out::println);
        });


        System.out.println("-------------------");

        System.out.println("Получить arraylist только с пользователями (экземпляры класса User, не Employee);");
        List<Human> arrayList = data.stream()
                .filter(v -> v instanceof User && !(v instanceof Employee))
                .toList();
        arrayList.forEach(System.out::println);

        System.out.println("Получить средний возраст;");
        double averageAge = data.stream()
                .mapToInt(Human::getAge)
                .average().getAsDouble();
        System.out.println((int) averageAge);

        System.out.println("Получить средний возраст среди несовершеннолетних;");
        averageAge = data.stream()
                .filter(x -> x.getAge() < 18)
                .mapToInt(Human::getAge)
                .average().getAsDouble();
        System.out.println((int) averageAge);

        System.out.println("Получить средний оклад на отдел;");
        Map<String, Double> averagePart = new HashMap<>();
        Employee.Go.getEmployees(data).stream()
                .collect(Collectors.groupingBy(Employee::getPart))
                .forEach((x, y) -> {
                    averagePart.put(x, y.stream()
                            .mapToDouble(z -> z.getSalary())
                            .average()
                            .getAsDouble());
                });
        averagePart.forEach((x, y) -> {
            System.out.println(x + " - " + y.toString());
        });

        System.out.println("Получить пользователей у которых почта \"gmail.com\". +: test@gmail.com, -: test@example.com;");
        List<User> user = Employee.Go.getUsers(data).stream()
                .filter(x ->
                        (x.getEmail().contains("gmail.com") || x.equals("test@gmail.com"))
                                && !(x.equals("test@example.com")
                        ))
                .toList();
        user.forEach(System.out::println);

        System.out.println("Получить электронные почты все совершеннолетних женщин,\n" +
                "не старше 30 лет, проживающих в Украине, которые являются сотрудниками.");
        List<String> mail = new ArrayList<>();
        Employee.Go.getEmployees(data).stream()
                .filter(x -> x.getSex().equals(Sex.WOMAN) &&
                        (x.getAge() >= 18 && x.getAge() <= 30) &&
                        x.getCountryLeave().equals(Countries.UKRAINE.toString())
                )
                .forEach(x -> {
                    mail.add(x.getEmail() + " | " + x.toString());
                });
        mail.forEach(System.out::println);
    }
}
