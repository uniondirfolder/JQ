package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        System.out.println(MainApp.class.getName());
        System.out.println(String.class);
        System.out.println(int.class);
        System.out.println(int[].class);
        System.out.println(int[][].class);
        System.out.println(void.class);

        Class stringCl1 ="Java".getClass();
        Class stringCl2 = String.class;
        try {
            Class stringCl3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class classUnit = Unit.class; // получаем ссылку на клас
        Method[] methods = classUnit.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        Unit unit = new Unit(1,2,3);
        try {
            methods[0].setAccessible(true);
            methods[0].invoke(unit); // вытаскивает в разном порядке
            methods[1].setAccessible(true);
            methods[1].invoke(unit);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        int mods = methods[0].getModifiers();
        methods[1].setAccessible(true);
        System.out.println("isStatic = " + Modifier.isStatic(mods));
        System.out.println("isFinal = " + Modifier.isFinal(mods));
        System.out.println("isPublic = " + Modifier.isPublic(mods));

        Field[] fields = classUnit.getDeclaredFields();
        System.out.println(Arrays.toString(fields));

        try {
            System.out.println(fields[1].get(unit));
            fields[1].set(unit, 20);
            System.out.println(fields[1].get(unit));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Unit unit1 = (Unit) classUnit.getDeclaredConstructor().newInstance(); // default, if many?
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(unit);

        try {
            Unit unit2 = (Unit) classUnit.getConstructor(int.class,int.class,int.class).newInstance(20,30,40);
            System.out.println(unit2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
//             String file = "C:\\REPO\\JQ\\temp\\ReflectionTest.class";
//            URL[] urls = new URL[]{new File(file).toURI().toURL()};
//            URLClassLoader urlClassLoader = new URLClassLoader(urls);
//            ClassLoader classLoader = urlClassLoader;
//
//            Class classHuman = classLoader.loadClass("ReflectionTest");
//            Object objHuman = classHuman.getConstructor(String.class,int.class).newInstance("Bob", 30);
//            Method greetingMethod = classHuman.getDeclaredMethod("print");
//            greetingMethod.invoke(objHuman);
//            File file = new File("C:\\REPO\\JQ\\temp\\ReflectionTest.class");
//
//            //convert the file to URL format
//            URL url = file.toURI().toURL();
//            URL[] urls = new URL[]{url};
//
//            //load this folder into Class loader
//            ClassLoader cl = new URLClassLoader(urls);
//
//            //load the Address class in 'c:\\other_classes\\'
//            Class  cls = cl.loadClass("com.nvv.ReflectionTest");
//
//            //print the location from where this class was loaded
//            ProtectionDomain pDomain = cls.getProtectionDomain();
//            CodeSource cSource = pDomain.getCodeSource();
//            URL urlfrom = cSource.getLocation();
//            System.out.println(urlfrom.getFile());
            CustomClassLoaderDemo loader = new CustomClassLoaderDemo();
            Class<?> c = loader.findClass("C:\\REPO\\JQ\\temp\\ReflectionTest");
            Object ob = c.getConstructor(String.class,int.class).newInstance("Bob", 30);
            Method md = c.getMethod("print");
            md.invoke(ob);

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
