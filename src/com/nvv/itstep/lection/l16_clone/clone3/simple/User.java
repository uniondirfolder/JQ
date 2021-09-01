package com.nvv.itstep.lection.l16_clone.clone3.simple;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private int age;

    public User(String login, int age) {
        this.login = login;
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                '}';
    }
}
