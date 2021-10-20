package com.nvv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalaryController {
    @GetMapping("/")
    public String getInfoForAllEmployees(){
        return "view-all";
    }
    @GetMapping("/hr_info")
    public String getInfoOnlyForHr(){
        return "view-for-hr";
    }
    @GetMapping("/manager_info")
    public String getInfoOnlyForManager(){
        return "view-for-manager";
    }
}
