package itstep.lection.l16_clone.clone1.deep;

public class User{
    private String login;
    private int age;
    private Address address;//null

    public User(String login, int age, Address address) {
        this.login = login;
        this.age = age;
        this.address = new Address(address);
    }

    public User(User user) {
        login = user.login;
        age = user.age;
        address = new Address(user.address);
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
