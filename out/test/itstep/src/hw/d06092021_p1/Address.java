package hw.d06092021_p1;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

@CopyConstructor
public class Address implements Cloneable,Serializable,Comparable<Address> {
    private String streetAddress;
    private String city;
    private String postalCode;

    public Address(String streetAddress, String city, String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
    }

    @CopyConstructor
    public Address(Address that) throws ConstructorException {
        try {
            if (!that.getClass().isAnnotationPresent(CopyConstructor.class)) {
                throw new ConstructorException("Copy constructor not found!");
            }
            this.streetAddress = that.streetAddress;
            this.city = that.city;
            this.postalCode = that.postalCode;
        } catch (Exception e) {
            throw new ConstructorException(e.getMessage());
        }
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Address getSerializeCopy() throws ConstructorException {
        try {
            Address _new = new MemorySerializer<Address>().serialize(this);
            return _new;
        } catch (IOException | ClassNotFoundException e) {
            throw new ConstructorException(e.getMessage());
        }
    }
    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return streetAddress.equals(address.streetAddress) && city.equals(address.city) && postalCode.equals(address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAddress, city, postalCode);
    }

    @Override
    public int compareTo(Address o) {
        if (this.equals(o)) {
            return 0;
        }
        int i = this.streetAddress.length() - o.streetAddress.length();
        if (i == 0) {
            i = this.city.length() - o.city.length();
            if (i == 0) {
                i = this.postalCode.length() - o.postalCode.length();
            }
        }
        return i;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
