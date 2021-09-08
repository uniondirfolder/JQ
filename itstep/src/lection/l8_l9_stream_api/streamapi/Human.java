package lection.l8_l9_stream_api.streamapi;

public class Human {
    private String name;
    private int age;
    private Speciality speciality;

    public Human(String name, int age, Speciality speciality) {
        this.name = name;
        this.age = age;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", speciality=" + speciality +
                '}';
    }
}
