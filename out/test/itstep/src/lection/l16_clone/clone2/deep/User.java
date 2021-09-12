package lection.l16_clone.clone2.deep;

public class User implements Cloneable{
    private String login;
    private int age;
    private Address address;

    public User(String login, int age, Address address) {
        this.login = login;
        this.age = age;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        User clone = (User) super.clone();
        clone.address = address.clone();
        return clone;
    }
}
