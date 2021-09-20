package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App_1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("appContext_1.xml");
        Address_1 address_1 = context.getBean("address_1", Address_1.class);
        User_1 user_1 = (User_1) context.getBean("user_1");
    }
}
