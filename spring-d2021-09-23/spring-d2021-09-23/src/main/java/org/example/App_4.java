package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App_4 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config_1.class);
        User_2 user_2 = context.getBean("user_2", User_2.class);
        System.out.println(user_2.info());
        context.close();
    }
}
