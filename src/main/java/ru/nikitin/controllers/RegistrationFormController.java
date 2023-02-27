package ru.nikitin.controllers;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.nikitin.entities.User;

import java.util.Collection;

@Data
public class RegistrationFormController {
    private String username;
    private String password;
    private String email;
//    private Collection role;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password),
                email);
    }
}
