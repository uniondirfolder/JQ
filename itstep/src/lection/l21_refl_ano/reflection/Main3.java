package lection.l21_refl_ano.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main3 {
    public static void main(String[] args) {
        try {
            Constructor constructor = User.class.getDeclaredConstructor(String.class);
            try {
                constructor.setAccessible(true);
                User user = (User) constructor.newInstance("Artem");
                System.out.println(user.getSurName());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
