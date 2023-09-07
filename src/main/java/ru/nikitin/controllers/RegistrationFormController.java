package ru.nikitin.controllers;

import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.nikitin.entities.User;

import java.util.Collection;

@Data
public class RegistrationFormController {
    private String username;
    private String password;
    private String email;
    private Collection role;

    public User toUser(@NonNull PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password),
                email);
    }
    public User toUser() {
        return new User(username, email, role.toString());
    }
}
