package com.nvv;

import com.nvv.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Communication communication = context.getBean("communication", Communication.class);
        List<Employee> employeeList = communication.getAllEmployees();

        employeeList.forEach(System.out::println);

        //System.out.println(communication.getEmployeeById(1));

//        communication.saveEmployee(new Employee(0,"str1","str2", "str3",1000));
//        communication.updateEmployee(new Employee(5,"str11","str22", "str33",3000));
        communication.deleteEmployee(2);
    }
}
