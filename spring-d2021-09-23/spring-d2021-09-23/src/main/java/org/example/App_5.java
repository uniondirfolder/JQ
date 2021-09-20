package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App_5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config_2.class);
        User_3 user_3 = context.getBean("user_3_Bean", User_3.class);
        user_3.setFirstName("Mee");
        System.out.println(user_3);
    }
}
