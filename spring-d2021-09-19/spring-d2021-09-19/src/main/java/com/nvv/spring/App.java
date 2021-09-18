package com.nvv.spring;


import com.nvv.spring.model.Address;
import com.nvv.spring.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Address address = context.getBean("userAddress", Address.class);
        User user = context.getBean("curUser", User.class);

        System.out.println(address);
        System.out.println(user);
    }
}
