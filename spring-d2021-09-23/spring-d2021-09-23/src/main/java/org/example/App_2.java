package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App_2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("appContext_2.xml");

        //Address_2 address_2 = (Address_2) context.getBean("address_task_2");
        //User_2 user_2 = context.getBean("user_2",User_2.class);
        GlobalAddress globalAddress = (GlobalAddress) context.getBean("address_task_2");
        User_2 user_2 = context.getBean("user_2",User_2.class);
        System.out.println(user_2);
        System.out.println(user_2.getAddress());
        //System.out.println(address_2);
        System.out.println(globalAddress);
        System.out.println(user_2.info());
        context.close();
    }
}
