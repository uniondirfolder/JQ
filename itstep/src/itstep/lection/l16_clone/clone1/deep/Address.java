package itstep.lection.l16_clone.clone1.deep;

public class Address {
    private String streetName;
    private String homeNumber;

    public Address(String streetName, String homeNumber) {
        this.streetName = streetName;
        this.homeNumber = homeNumber;
    }

    public Address(Address address) {
        streetName = address.streetName;
        homeNumber = address.homeNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                '}';
    }
}
