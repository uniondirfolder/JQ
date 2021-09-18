package lection.l21_refl_ano.reflection;


import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        //
        //Class aClass;
//        try {
//            Class<?> class1 = Class.forName("reflection.User");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        User user = new User("Ivan", "Ivanov");
//        Class<? extends User> class2 = user.getClass();

//        Class<User> class3 = User.class;

        Class<User> userClass = User.class;

//        Method[] methods = userClass.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

//        Field[] fields = userClass.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }

//        try {
//            Field field = userClass.getDeclaredField("name");
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }

        try {
            Method method = userClass.getDeclaredMethod("privateMethod",String.class,int.class);
            System.out.println(method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
