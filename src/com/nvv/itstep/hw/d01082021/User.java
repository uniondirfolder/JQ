package com.nvv.itstep.hw.d01082021;


import com.nvv.itstep.hw.d01082021.enums.Sex;

import java.util.Objects;

// 1. Создать класс User, который должен хранить следующую инф. о пользователе: полное имя, возраст, пол, электронную почту, страну проживания;
@Developer
public class User extends Human {
    private String email;
    private String countryLeave;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryLeave() {
        return countryLeave;
    }

    public void setCountryLeave(String countryLeave) {
        this.countryLeave = countryLeave;
    }

    public User(String firstName, String lastName, int age, Sex sex, String email, String countryLeave) {
        super(firstName, lastName, age, sex);
        this.email = email;
        this.countryLeave = countryLeave;
    }

    public User(Human that, String email, String countryLeave) {
        super(that);
        this.email = email;
        this.countryLeave = countryLeave;
    }

    public User(User that) {
        super(that);
        this.email = that.email;
        this.countryLeave = that.countryLeave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) && getCountryLeave().equals(user.getCountryLeave());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEmail(), getCountryLeave());
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", countryLeave='" + countryLeave + '\'' +
                '}' + ' ' + super.toString();
    }

}
