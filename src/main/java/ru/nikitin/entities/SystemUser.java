package ru.nikitin.entities;


import org.jetbrains.annotations.NotNull;
import ru.nikitin.validation.FieldMatch;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class SystemUser {

    @Size(min = 3, message = "username length must be greater than 2 symbols")
    private String userName;


    @Size(min = 1, message = "is required")
    private String password;


    @Size(min = 1, message = "is required")
    private String matchingPassword;


    @Size(min = 1, message = "is required")
    private String firstName;


    @Size(min = 1, message = "is required")
    private String lastName;


    @Size(min = 1, message = "is required")
    @Email
    private String email;
}
