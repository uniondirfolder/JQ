package hw.d10092021.sql.types;

import hw.d10092021.sql.enums.SQLite;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Handle {
    boolean onUpdate() default false;
    boolean onDelete() default false;
    boolean onConflict() default false;
    boolean sorting() default false;
    SQLite action() default SQLite.NO_ACTION;
}
