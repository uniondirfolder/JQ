package com.nvv.entrepreneur.controllers;

import com.nvv.entrepreneur.domain.User;
import com.nvv.entrepreneur.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @RequestParam("password2") String passwordConfirmation,
            @Valid User user,
            BindingResult bindingResult,
            Model model) {


        boolean isConfirmEmpty = (passwordConfirmation==null || passwordConfirmation.isEmpty());

        if(isConfirmEmpty){
            model.addAttribute("password2Error", "Password confirmation cannot be empty");
        }

        if(user.getPassword()!=null && !user.getPassword().equals(passwordConfirmation)){
            model.addAttribute("passwordError", "Password are different!");
        }

        if(isConfirmEmpty || bindingResult.hasErrors())
        {
            var errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(ControllerUtils.getErrors(bindingResult));
            return "registration";
        }

        if (!userService.addUser(user)) {
            model.addAttribute("usernameError", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivate = userService.activateUser(code);

        if(isActivate){
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "User successfully activated");
        }else{
            model.addAttribute("messageType", "danger");
            model.addAttribute("message","Activation is not found!");
        }
        return "login";
    }

}
