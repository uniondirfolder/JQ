package lection.l18_l19JDBC;

public class User {
    private long id;
    private String nameF;
    private String nameL;

    public User(long id, String nameF, String nameL) {
        this.id = id;
        this.nameF = nameF;
        this.nameL = nameL;
    }

    public String getNameF() {
        return nameF;
    }

    public void setNameF(String nameF) {
        this.nameF = nameF;
    }

    public String getNameL() {
        return nameL;
    }

    public void setNameL(String nameL) {
        this.nameL = nameL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nameF='" + nameF + '\'' +
                ", nameL='" + nameL + '\'' +
                '}';
    }
}
