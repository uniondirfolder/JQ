package hw.d18092021.d06092021_p1;

import hw.d18092021.json.JsonConstructor;
import hw.d18092021.json.JsonCursor;
import hw.d18092021.json.JsonItem;
import hw.d18092021.json.JsonParse;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@CopyConstructor
public class Developer implements Cloneable, Serializable, Comparable<Developer>, JsonParse {
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

    @JsonConstructor
    private Developer(JsonCursor jsonCursor) {
        Class cl = this.getClass();
        Field[] fl = cl.getDeclaredFields();
        int i = -1;

        JsonItem ji = jsonCursor.getWithUnclouded();
        if (ji != null && !jsonCursor.isError() && jsonCursor.getCursor() && jsonCursor.checkFieldRule(ji) && fl[++i].getName().equals(ji.getFieldName())) {
            this.firstName = ji.getValue();

            ji = jsonCursor.getWithUnclouded();
            if (ji != null && !jsonCursor.isError() && jsonCursor.getCursor() && jsonCursor.checkFieldRule(ji) && fl[++i].getName().equals(ji.getFieldName())) {
                this.lastName = ji.getValue();

                ji = jsonCursor.getWithUnclouded();
                if (ji != null && !jsonCursor.isError() && jsonCursor.getCursor() && jsonCursor.checkFieldRule(ji) && fl[++i].getName().equals(ji.getFieldName())) {
                    if (ji.getValue().equals("object")) {
                        try {
                            Constructor constructor = Address.class.getDeclaredConstructor(JsonCursor.class);
                            constructor.setAccessible(true);
                            address = (Address) constructor.newInstance(jsonCursor);

                            ji = jsonCursor.getWithUnclouded();
                            if (ji != null && !jsonCursor.isError() && jsonCursor.getCursor() && jsonCursor.checkFieldRule(ji) && fl[++i].getName().equals(ji.getFieldName())) {
                                if (ji.getValue().equals("array")) {
                                    phoneNumbers = new String[ji.getDimension()];
                                    for (int j = 0; j < ji.getDimension(); j++) {
                                        phoneNumbers[j]=ji.getArray()[j];
                                    }
                                } else {
                                    jsonCursor.setError(true);
                                }
                            } else {
                                jsonCursor.setError(true);
                            }


                        } catch (NoSuchMethodException e) {
                            jsonCursor.setError(true);
                        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                            jsonCursor.setError(true);
                        }

                    } else {
                        jsonCursor.setError(true);
                    }

                } else {
                    jsonCursor.setError(true);
                }
            } else {
                jsonCursor.setError(true);
            }
        } else {
            jsonCursor.setError(true);
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
        if(args.length>this.phoneNumbers.length){
            this.phoneNumbers = new String[args.length];
        }
        for (int i = 0; i < args.length; i++) {
            this.phoneNumbers[i] = args[i];
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

    public String toJson() {
        StringBuilder sb = new StringBuilder();
        Class cl = this.getClass();
        Field[] fl = cl.getDeclaredFields();
        int i = -1;

        sb.append("{\"" + fl[++i].getName() + "\":\"" + firstName + "\",");
        sb.append("\"" + fl[++i].getName() + "\":\"" + lastName + "\",");
        sb.append("\"" + fl[++i].getName() + "\":"  + address.toJson()+ ",");
        sb.append("\"" + fl[++i].getName() + "\":[");
        for (int j = 0; j < phoneNumbers.length; j++) {
            sb.append("\""+phoneNumbers[j]+"\"");
            if(j<phoneNumbers.length-1){sb.append(",");}
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }
}
