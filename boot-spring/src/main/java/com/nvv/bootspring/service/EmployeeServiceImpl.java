package com.nvv.bootspring.service;


import com.nvv.bootspring.dao.EmployeeRepository;
import com.nvv.bootspring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        //return employeeRepository.getEmployeesByNameAndDepartment()
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Employee e = null;
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            e = optional.get();
        }
        return e;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {

    }

}
