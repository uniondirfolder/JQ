package com.nvv.spring.model;

public class Address {
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

    public Address(String streetName, String buildNumber, String flatNumber) {
        this.streetName = streetName;
        this.buildNumber = buildNumber;
        this.flatNumber = flatNumber;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", buildNumber='" + buildNumber + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                '}';
    }
}
