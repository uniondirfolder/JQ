package com.nvv.itstep.hw.d06092021_p1;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@CopyConstructor
public class Developer implements Cloneable, Serializable, Comparable<Developer> {
    private String firstName;
    private String lastName;
    private Address address;
    private String phoneNumbers[];

    public Developer(String firstName, String lastName, Address address, String[] phoneNumbers) throws ConstructorException {
        try {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.phoneNumbers = phoneNumbers;
        } catch (Exception e) {
            throw new ConstructorException(e.getMessage());
        }
    }

    @CopyConstructor
    public Developer(Developer that) throws ConstructorException {
        try {
            if (!that.getClass().isAnnotationPresent(CopyConstructor.class)) {
                throw new ConstructorException("Copy constructor not found!");
            }
            this.firstName = that.firstName;
            this.lastName = that.lastName;
            this.address = new Address(that.address);
            this.phoneNumbers = new String[that.phoneNumbers.length];
            for (int i = 0; i < phoneNumbers.length; i++) {
                phoneNumbers[i] = that.phoneNumbers[i];
            }
        } catch (Exception e) {
            throw new ConstructorException(e.getMessage());
        }
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String... args) {
        try {
            if (args.length <= this.phoneNumbers.length) {
                for (int i = 0; i < args.length; i++) {
                    this.phoneNumbers[i] = args[i];
                }
            } else {
                this.phoneNumbers = new String[args.length];
                for (int i = 0; i < args.length; i++) {
                    this.phoneNumbers[i] = args[i];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Developer getSerializeCopy() throws ConstructorException {
        try {
            Developer _new = new MemorySerializer<Developer>().serialize(this);
            return _new;
        } catch (IOException | ClassNotFoundException e) {
            throw new ConstructorException(e.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer)) return false;
        Developer developer = (Developer) o;
        return firstName.equals(developer.firstName) && lastName.equals(developer.lastName) && address.equals(developer.address) && Arrays.equals(phoneNumbers, developer.phoneNumbers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(firstName, lastName, address);
        result = 31 * result + Arrays.hashCode(phoneNumbers);
        return result;
    }

    @Override
    protected Developer clone() throws CloneNotSupportedException {
        try {
            return new Developer(this.firstName, this.lastName, this.address.clone(), this.phoneNumbers.clone());
        } catch (ConstructorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int compareTo(Developer o) {
        if (this.equals(o)) return 0;
        int i = this.firstName.length() - o.lastName.length();
        if (i == 0) {
            i = this.lastName.length() - o.lastName.length();
            if (i == 0) {
                i = this.address.compareTo(o.address);
                if (i == 0) {
                    if (this.phoneNumbers.length == o.phoneNumbers.length) {
                        for (int j = 0; j < phoneNumbers.length; j++) {
                            i = phoneNumbers[j].compareTo(o.phoneNumbers[j]);
                            if (i == 0) continue;
                            else break;
                        }
                    } else {
                        i = this.phoneNumbers.length - o.phoneNumbers.length;
                    }

                }
            }
        }
        return i;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", phoneNumbers=" + Arrays.toString(phoneNumbers) +
                '}';
    }
}
