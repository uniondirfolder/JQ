package lection.l21_refl_ano.annotation;


//@SuppressWarnings("unused")
@FirstAnnotation
public class Parent {
    @FirstAnnotation
    private String name;

    public Parent(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("I'm Parent");
    }
}
