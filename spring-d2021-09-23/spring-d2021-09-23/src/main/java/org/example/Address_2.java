package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("address_task_2")
public class Address_2 implements GlobalAddress {
    @Value("${address_2.streetName}")
    private String streetName;
    @Value("${address_2.buildNumber}")
    private String buildNumber;
    @Value("${address_2.flatNumber}")
    private String flatNumber;

    public String getStreetName() {
        return streetName;
    }


    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public Address_2(String streetName, String buildNumber, String flatNumber) {
        this.streetName = streetName;
        this.buildNumber = buildNumber;
        this.flatNumber = flatNumber;
    }

    public Address_2() {
    }

//    @Override
//    public String toString() {
//        return "Address{" +
//                "streetName='" + streetName + '\'' +
//                ", buildNumber='" + buildNumber + '\'' +
//                ", flatNumber='" + flatNumber + '\'' +
//                '}';
//    }

    @PostConstruct
    public void init(){}

    @PreDestroy
    public void destroy(){}

    @Override
    public void somePrint() {

    }

    public String info() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", buildNumber='" + buildNumber + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                '}';
    }
}
