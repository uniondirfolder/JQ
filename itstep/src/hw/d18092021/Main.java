package hw.d18092021;

import hw.d18092021.d06092021_p1.Address;
import hw.d18092021.d06092021_p1.ConstructorException;
import hw.d18092021.d06092021_p1.Developer;
import hw.d18092021.d06092021_p1.Project;
import hw.d18092021.json.JsonObjects;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {


    public static void main(String[] args) {

        String[] phoneNumbers = {"044 123-1234", "050 123-4567"};
        Address address = new Address("вул. Грушевського 14, кв.101","Київ","21000");
        try {
            Developer developer = new Developer("Іван","Коваленко",address,phoneNumbers);
            Project project = new Project("FaceBook", developer);

            /*3.**Поробовать создать сложный объект(у юзера есть адрес)*/
            JsonObjects<Project> js = new JsonObjects<>();

            String str = js.toJson(project);
            System.out.println(str);

            Project project1 = js.fromJson(str,Project.class);

            System.out.println("-".repeat(15));
            System.out.println(project.compareTo(project1));
            System.out.println(project.equals(project1));

            System.out.println("-".repeat(15));
            project.getDeveloper().setPhoneNumbers("044 123-1235");
            System.out.println(project.compareTo(project1));
            System.out.println(project.equals(project1));

            System.out.println("-".repeat(15));

            /*2.Создать метод, который будет получать простой объект(firstName, secondName, phone)
и возвращать строку формата JSON.
Использовать рефлексию.*/
            System.out.println(JsonObjects.objectToJson(project));
            System.out.println("-".repeat(15));
            System.out.println(JsonObjects.printJson(project1));
            System.out.println("-".repeat(15));
            System.out.println(JsonObjects.printJson(project1.getDeveloper()));
            System.out.println("-".repeat(15));
            System.out.println(JsonObjects.printJson(project1.getDeveloper().getAddress()));
            System.out.println("-".repeat(15));


            /*1.Создать копию(клон) простого объекта(firstName, secondName, phone).
                    Использовать рефлексию.*/
            CustomClassLoader loader = new CustomClassLoader();
            Class<?> c = loader.findClass(Project.class.getCanonicalName());
            Constructor constructor = c.getDeclaredConstructor(String.class,Developer.class);
            Object ob = constructor.newInstance(project1.getProjectName(),project.getDeveloper());
            Method md = c.getMethod("setProjectName", String.class);
            md.invoke(ob,"VIKING");
            md =  c.getMethod("getProjectName");
            System.out.println(md.invoke(ob));


        } catch (ConstructorException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        ;

    }
}
