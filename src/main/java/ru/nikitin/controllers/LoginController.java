package ru.nikitin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showMyLoginPage() {
        return "login";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "access-denied";
    }
}
