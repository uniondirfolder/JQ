package com.nvv.itstep.hw.d01082021;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Developer {
    String dev() default "Narchuk Vadym";

    String email1() default "unitmac@icloud.com";

    String email2() default "uniondirfolder@gmail.com";

    String github() default "https://github.com/uniondirfolder/JQ";

}
