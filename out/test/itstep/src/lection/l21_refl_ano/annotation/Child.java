package lection.l21_refl_ano.annotation;



@Deprecated
public class Child extends Parent {
    public Child(String field) {
        super(field);
    }

    @Override
    public void info() {
        System.out.println("I'm Child");
    }
}
