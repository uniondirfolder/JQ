package com.nvv.itstep.lection.l8_l9_stream_api.builder;

public class User {
    private String firstName;
    private String lastName;
    private String phone;

    private User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static class Builder {
        private User user;

        public Builder() {
            user = new User();
        }

        public Builder setFirstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public Builder setPhone(String phone) {
            user.phone = phone;
            return this;
        }

        public User create() {
            return user;
        }
    }

}
