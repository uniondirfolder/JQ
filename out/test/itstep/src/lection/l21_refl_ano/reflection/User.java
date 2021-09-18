package lection.l21_refl_ano.reflection;

public class User {
    private String name;
    public String surName;

    public User(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    private User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getSurName() {
        return surName;
    }

    protected void setSurName(String surName) {
        this.surName = surName;
    }

    private void privateMethod(String test1, int test2) {
        System.out.println("private");
        System.out.println(test1 + test2);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
