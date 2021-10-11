package com.nvv.controller;

import com.nvv.entity.Employee;
import com.nvv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployee(Model model){
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("atr_list_employees", employeeList);
        return "all-employees";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Model model){
        Employee e = new Employee();
        model.addAttribute("atr_empl_info", e);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("atr_empl_info") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empl_id") int id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empl_id") int id, Model model){
        Employee e = employeeService.getEmployee(id);
        model.addAttribute("atr_empl_info", e);
        return "employee-info";
    }
}
