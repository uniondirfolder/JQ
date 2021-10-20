package com.nvv.bootspring.dao;

import com.nvv.bootspring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee>getEmployeesByNameAndDepartment(String name, String department);
}
