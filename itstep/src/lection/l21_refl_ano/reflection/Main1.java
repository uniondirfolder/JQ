package lection.l21_refl_ano.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {
        User user = new User("Stepan", "Stepanov");
//        System.out.println(user.name);
//        System.out.println(user.getName());

        Class<? extends User> userClass = user.getClass();
        try {
            Field field = userClass.getDeclaredField("name");
            field.setAccessible(true);
            System.out.println(field.get(user));
            field.set(user, "Petr");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


        System.out.println(user);
    }
}
