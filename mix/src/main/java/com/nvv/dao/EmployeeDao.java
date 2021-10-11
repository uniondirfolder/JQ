package com.nvv.dao;

import com.nvv.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
