package com.example.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.web.service.LoginService;

@Controller
public class LoginController{

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false) boolean logout, Model model) {
        if (logout == true) { 
            model.addAttribute("message", "Logout successful.");
        }
        return "login.html";
    }

    @PostMapping("/login")
    public String attemptLogin(@RequestParam String username, @RequestParam String password, Model model) {

        Boolean loginResult = loginService.validateLogin(username, password);
        if(loginResult == true) {
            return "redirect:/main";
        } else {
            model.addAttribute("message", "Invalid username or password.");
            return "login.html";
        }
    }
}