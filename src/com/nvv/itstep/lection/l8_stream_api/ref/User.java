package com.nvv.itstep.lection.l8_stream_api.ref;

public class User {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User(String firstName) {
        this.firstName = firstName;
    }

    public User(User user) {
        this.firstName = user.firstName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}
