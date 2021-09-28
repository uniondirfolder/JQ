package com.cool;

import com.cool.entity.Course;
import com.cool.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = null;

        try{
            session = factory.getCurrentSession();

            Course course = new Course("N19-05-6 WEB",new Date());

            Student student1 = new Student("Bob","Kurtz", "4587988-18114","USA");
            Student student2 = new Student("Micky","Li", "AS2564/54","China");
            Student student3 = new Student("Liza","Pot", "EG565687/96-987","Great Britain");
            course.addStudentToCourse(student1);
            course.addStudentToCourse(student2);
            course.addStudentToCourse(student3);

            session.beginTransaction();

            session.save(course);

            session.beginTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }

        System.out.println("Hello World!");
    }
}