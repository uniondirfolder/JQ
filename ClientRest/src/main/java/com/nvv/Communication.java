package com.nvv;

import com.nvv.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/employees";

    @Autowired
    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {
                });
        List<Employee> employeeList = responseEntity.getBody();
        return employeeList;

    }

    public Employee getEmployeeById(int id) {
        Employee e = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return e;
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getKeyId();
        if (id == 0) {
            ResponseEntity<Employee> responseEntity = restTemplate.postForEntity(URL, employee, Employee.class);
            //ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println(responseEntity.getBody());
        }
    }

    public void updateEmployee(Employee employee) {
        int id = employee.getKeyId();
        if (id != 0) {
            restTemplate.put(URL, employee);
            ResponseEntity<Employee> responseEntity = restTemplate.postForEntity(URL, employee, Employee.class);
            //ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println(responseEntity.getBody());
        }
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
    }
}
