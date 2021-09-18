package lection.l21_refl_ano.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main2 {
    public static void main(String[] args) {
        User user = new User("Test", "Testovich");
        Class<? extends User> userClass = user.getClass();

        try {
            Method method = userClass.getDeclaredMethod("privateMethod", String.class, int.class);
//            System.out.println(method.getName());
//            int modifier = method.getModifiers();
//            System.out.println(Modifier.isPrivate(modifier));
//            System.out.println(method.getReturnType());
            method.setAccessible(true);
            method.invoke(user, "2",2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
