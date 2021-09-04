package com.nvv.itstep.hw.d06092021_p2.GoF.creational.Builder.builder;

public class BankAccountInner {
    private String name;
    private String number;
    private String email;
    private boolean isActive;

    private BankAccountInner(AccountBuilder builder) {
        name = builder.name;
        number = builder.number;
        email = builder.email;
        isActive = builder.isActive;
    }

    public static class AccountBuilder {
        private String name;
        private String number;
        private String email;
        private boolean isActive;

        public AccountBuilder(String name, String number) {
            this.name = name;
            this.number = number;
        }

        public AccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder withStatus(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public BankAccountInner build() {
            return new BankAccountInner(this);
        }
    }

    @Override
    public String toString() {
        return "Account: " + name + " #" + number + ", email: " + email + ", Status: " + isActive;
    }
}
