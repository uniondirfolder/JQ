package lection.l16_clone;

public class User implements Cloneable{
    private String login;
    private int age;
    private Address address;

    public User(String login, int age, Address address) {
        this.login = login;
        this.age = age;
        this.address = new Address(address.getStreetName(),address.getStreetName());
//        try {
//            address = address.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
    }

    public User(User user) {
        this.age = user.age;
        this.login = user.login;
        try {
            this.address = user.address.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

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
                '}';
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.address = address.clone();
        return user;
    }

}
