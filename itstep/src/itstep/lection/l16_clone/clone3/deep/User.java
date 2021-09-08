package itstep.lection.l16_clone.clone3.deep;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private int age;
    private Address address;

    public User(String login, int age, Address address) {
        this.login = login;
        this.age = age;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
                ", address=" + address +
                '}';
    }
}
