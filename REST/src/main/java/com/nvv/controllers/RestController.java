package com.nvv.controllers;

import com.nvv.entity.Employee;
import com.nvv.except.EmployeeIncorrectData;
import com.nvv.except.NoSuchEmployeeException;
import com.nvv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private EmployeeService employeeService;

    @Autowired
    public RestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> list = employeeService.getAllEmployees();
        return list;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee e = employeeService.getEmployee(id);
        if (e == null) {
            throw new NoSuchEmployeeException("No such data " + id);
        }
        return e;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee e = employeeService.getEmployee(id);
        if (e == null) {
            throw new NoSuchEmployeeException("No such data " + id);
        } else {
            employeeService.deleteEmployee(id);
            return "Employee with ID = " + id + " was deleted";
        }
    }
}
