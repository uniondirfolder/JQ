package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class testClass = TestClass.class;
        Method[] methods = testClass.getDeclaredMethods();
        List<Method> exucutionList = Arrays.stream(TestClass.class.getDeclaredMethods())
                .filter(m->m.isAnnotationPresent(MyAnno.class))
                .sorted((o1,o2)->o2.getAnnotation(MyAnno.class).priority() - o1.getAnnotation(MyAnno.class).priority())
                .collect(Collectors.toList());
        for (Method method : exucutionList) {
            method.invoke(null);
        }
    }
}
