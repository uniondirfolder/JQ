package com.nvv.itstep.lection.l7_cf.home;

import java.util.Objects;

public class User {
    private String name;
    private String lastname;
    private int age;

    public User() {
        this("userName", "userLastname", 0);
    }

    public User(String name) {
        this(name, "userLastname", 0);
    }

    public User(String name, String lastname) {
        this(name, lastname, 0);
    }

    public User(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0 || age > 100) this.age = 0;
        else this.age = age;
    }

//    @Override
//    public boolean equals(Object o) {// 1     2
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return age == user.age && Objects.equals(name, user.name) && Objects.equals(lastname, user.lastname);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, lastname, age);
//    }

    @Override
    public String toString() {
        return "Name: " + name + "; Lastname: " + lastname + "; Age: " + age + ";";
    }
}
