package com.nvv.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        TestBean tb = context.getBean("testBean", TestBean.class);

        UserDAO userDAO = context.getBean("userDAO", UserDAO.class);
        System.out.println(userDAO.getAllUsers());
        userDAO.setX(10);
        System.out.println(userDAO.getX()); // странное исключение
        userDAO.longOperation();

//        System.out.println(userDAO.getAllUsers());
//        userDAO.setX(13);
//        userDAO.deleteUser();
//        userDAO.updateUser();

//        com.nvv.aop.ExternalSystemUserDAO externalSystemUserDAO = context.getBean("externalSystemUserDAO", com.nvv.aop.ExternalSystemUserDAO.class);

//        userDAO.addUser();
//        userDAO.updateUser();
//        userDAO.deleteUser();
//        userDAO.findAll();
//        userDAO.findOneById(1L);
//        userDAO.getX();
//        userDAO.setX(10);

//        System.out.println("------------------");
//
//        System.out.println(userDAO.getX());
//        userDAO.setX(10);
//        System.out.println(userDAO.getX());
//
//        System.out.println("from Main: " + userDAO.getAllUsers());
//
//        userDAO.longOperation();
//
//        externalSystemUserDAO.addUser();


        context.close();
    }
}
