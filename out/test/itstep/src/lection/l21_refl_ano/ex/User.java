package lection.l21_refl_ano.ex;

public class User {
    @AllowShowing
    private String firstName;
    @AllowShowing(value = false)
    private String lastName;

    private String phone;

    public User(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
}
