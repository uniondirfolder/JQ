package hw.d01082021;


import hw.d01082021.enums.Sex;

import java.util.Objects;

@Developer
public class Human {
  private String firstName;
  private String lastName;
  private int age;
  private Sex sex;

    public Human(String firstName, String lastName, int age, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Human(Human that) {
        this.firstName = that.firstName;
        this.lastName = that.lastName;
        this.age = that.age;
        this.sex = that.sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() && getFirstName().equals(human.getFirstName()) && getLastName().equals(human.getLastName()) && getSex() == human.getSex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAge(), getSex());
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

}
