package com.nvv.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
public class FirstController {

    @RequestMapping("/")
    public String showFirstView() {
        return "zero";
    }

    @RequestMapping("/registration")
    public String askRegistration() {
        return "first";
    }

    @RequestMapping("/confirm")
    public String confirmRegistration(HttpServletRequest httpServletRequest) { //
        String str = httpServletRequest.getParameter("form_Create");
        if(str.equals("true")){
            return "second";
        }
        return "first";
    }
}
