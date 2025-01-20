package ru.nikitin.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nikitin.entities.User;
import ru.nikitin.repositories.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;
    private User user;
    public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm(){
        return "registration";
    }
    @PostMapping
    public String processRegistration(RegistrationFormController form){
        User users = userRepo.findUserByEmail(String.valueOf(user));
        if(users == null) {
            userRepo.save(form.toUser(passwordEncoder));
            return "redirect:/login";
        }throw new DataIntegrityViolationException("Такой пользователь существует");
    }
}
