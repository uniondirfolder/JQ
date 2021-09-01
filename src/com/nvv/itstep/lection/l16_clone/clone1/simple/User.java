package com.nvv.itstep.lection.l16_clone.clone1.simple;

public class User {
    private String login;
    private int age;

    public User(String login, int age) {
        this.login = login;
        this.age = age;
    }

    public User(User user) {
        login = user.login;
        age = user.age;
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
