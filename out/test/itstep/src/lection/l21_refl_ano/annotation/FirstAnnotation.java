package lection.l21_refl_ano.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstAnnotation {
    enum Color {
        RED, GREEN, BLUE
    }

      int KEY = 7;//константа

    //int key1();
    int key2() default 3;

    //String value() default "def";

    //String []words();

    //Color color();
}
