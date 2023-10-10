package com.example.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.web.service.LoggedUserManagementService;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String mainPage(@RequestParam(required = false) boolean logout, Model model) {

        if (logout == true) {
            loggedUserManagementService.setUsername(null);
            return "redirect:/login?logout=true";
        }

        if(loggedUserManagementService.getUsername() == null) {
            return "redirect:/login";
        }

        model.addAttribute("type", loggedUserManagementService.getType());
        model.addAttribute("username", loggedUserManagementService.getUsername());
        return "main.html";
    }

    @GetMapping("/main/admin")
    public String adminPage(Model model) {

        if(loggedUserManagementService.getUsername() == null || !loggedUserManagementService.getType().equals("admin")){
            return "redirect:/main";
        }

        model.addAttribute("username", loggedUserManagementService.getUsername());
        return "admin.html";
    }
}
