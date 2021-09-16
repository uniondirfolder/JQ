package hw.d18092021.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonConstructor {
    String dev() default "Vadym Narchuk ";

    String email1() default "unitmac@icloud.com";

    String email2() default "uniondirfolder@gmail.com";

    String github() default "https://github.com/uniondirfolder/JQ";
}
