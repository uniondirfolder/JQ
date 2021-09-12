package lection.l21_refl_ano.ex;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        User user = new User("Ivan", "Ivanov", "666");
        print(user);
    }

    private static void print(Object o) {
        Class<?> classObject = o.getClass();
        Field[] fields = classObject.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AllowShowing.class) && field.getAnnotation(AllowShowing.class).value()) {
                field.setAccessible(true);
                try {
                    System.out.println(field.get(o));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
