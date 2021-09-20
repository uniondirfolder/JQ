package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class User_2 {
    @Value("${user_2.firstName}")
    private String firstName;
    @Value("${user_2.lastName}")
    private String lastName;
    @Value("${user_2.phone}")
    private String phone;
    private GlobalAddress address;


//    @Autowired //- not work
//    public User_2(String firstName, String lastName, String phone, @Qualifier("address_2") GlobalAddress address) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.address = address;
//    }

    //- not work if only one constructor(without @Autowired). if with @Autowired-not work. if no on setter annotation @Autowired - will be null

    public User_2(String firstName, String lastName, String phone, @Qualifier("address_task_2") GlobalAddress address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public User_2() {
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

    public GlobalAddress getAddress() {
        return address;
    }

    @Autowired
    public void setAddress(@Qualifier("address_task_2") GlobalAddress addressSp) {
        this.address = addressSp;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phone='" + phone + '\'' +
//                ", address=" + address +
//                '}';
//    }

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void destroy() {
    }

    public String info() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + ((Address_2) address).info() +
                '}';
    }
}
