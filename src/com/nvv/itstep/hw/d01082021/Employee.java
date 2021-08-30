package com.nvv.itstep.hw.d01082021;


import com.nvv.itstep.hw.d01082021.enums.Sex;
import com.nvv.itstep.hw.d01082021.enums.Speciality;

import java.util.*;

// 2. Создать класс Employee, который должен хранить следующую информацию: вся инф. о User,
//оклад, должность, отдел;
@Developer
public class Employee extends User {
    private float salary;
    private Speciality profession;
    private String part;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Speciality getProfession() {
        return profession;
    }

    public void setProfession(Speciality profession) {
        this.profession = profession;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public Employee(String firstName, String lastName, int age, Sex sex, String email, String countryLeave, float salary, Speciality profession, String part) {
        super(firstName, lastName, age, sex, email, countryLeave);
        this.salary = salary;
        this.profession = profession;
        this.part = part;
    }

    public Employee(User that, float salary, Speciality profession, String part) {
        super(that);
        this.salary = salary;
        this.profession = profession;
        this.part = part;
    }

    public Employee(Employee that) {
        super(that);
        this.salary = that.salary;
        this.profession = that.profession;
        this.part = that.part;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Float.compare(employee.getSalary(), getSalary()) == 0 && getProfession().equals(employee.getProfession()) && getPart().equals(employee.getPart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSalary(), getProfession(), getPart());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", profession=" + profession.toString() +
                ", part='" + part + '\'' +
                '}'+ ' ' + super.toString();
    }

    interface Go {
        static Map<Speciality, ArrayList<Employee>> getMapHumansByProfession(Collection<Human> collection) {
            Map<Speciality, ArrayList<Employee>> result = new HashMap<>();
            ArrayList<Employee> list = getEmployees(collection);
            list.forEach((v) -> {
                if (!result.containsKey(v.getProfession())) {
                    ArrayList<Employee> toAddList = new ArrayList<>();
                    list.forEach((x) -> {
                        if (x.getProfession().equals(v.getProfession())) {
                            toAddList.add(x);
                        }
                    });
                    if (toAddList.size() > 0) {
                        result.put(v.getProfession(), toAddList);
                    }
                }
            });
            return result;
        }

        static ArrayList<User> getUsers(Collection<Human> humans){
            ArrayList<User> temp = new ArrayList<>();
            humans.forEach(x->{
                if(x instanceof User && !(x instanceof Employee)){
                    temp.add((User)x);
                }
            });
            return  temp;
        }
        static ArrayList<Employee> getEmployees(Collection<Human> humans){
            ArrayList<Employee> temp = new ArrayList<>();
            humans.forEach(x->{
                if(x instanceof Employee){
                    temp.add((Employee) x);
                }
            });
            return  temp;
        }

    }
}
