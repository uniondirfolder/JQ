package org.example;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Address_3 implements GlobalAddress {
    private String streetName;
    private String buildNumber;
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

    public Address_3(String streetName, String buildNumber, String flatNumber) {
        this.streetName = streetName;
        this.buildNumber = buildNumber;
        this.flatNumber = flatNumber;
    }

    public Address_3() {
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
