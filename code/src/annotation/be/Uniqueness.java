package annotation.be;


public @interface Uniqueness {
    Constrains constrains() default @Constrains(unique = true);
}
