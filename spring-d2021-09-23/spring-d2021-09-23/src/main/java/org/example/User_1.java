package org.example;

public class User_1 {
    private String firstName;
    private String lastName;
    private String phone;
    private Address_1 address;

    public User_1(String firstName, String lastName, String phone, Address_1 address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public User_1() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address_1 getAddress() {
        return address;
    }

    public void setAddress(Address_1 addressSp) {
        this.address = addressSp;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }

    public void init(){}

    public void destroy(){}
}
