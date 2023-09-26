package ru.nikitin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import ru.nikitin.entities.User;
import ru.nikitin.repositories.UserRepository;
import ru.nikitin.services.UserService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final BCryptPasswordEncoder passwordEncoder;
    private UserService userService;
    private UserRepository userRepositories;

    @Autowired
    public AdminController(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAdminDashboard() {
        return "admin-panel";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin-panel";
    }
    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", userService.findUserById(id));
        return "edit-user-panel";
    }

    @GetMapping("/edit-user-panel")
    public String updateUser(Model model,User user) {
        model.addAttribute("user", userService.update(user));
        return "redirect:admin-panel";

    }

    @PostMapping("/edit/{id}")
    public String processUserAddForm( @ModelAttribute("user") @Valid User user, BindingResult theBindingResult, Model model) {
        if (user.getId() == 0 && userService.getByName(String.valueOf(user)).isEmpty()) {
            theBindingResult.addError(new ObjectError("user.id",
                    "Пользователь с таким номером уже существует")); // todo не отображает сообщение
        }
        if (theBindingResult.hasErrors()) {
            model.addAttribute("user", userService.getAllUsers());
            return "redirect:/admin/users";
        }
        userService.update(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/del/{id}")
    public String deleteById(@PathVariable(name = "id")  Long id) {
        if (userService.findUserById(id).equals(id)) {
            userService.deleteUserById(userService.findUserById(id).getId());
            return "redirect:/admin-panel";
        }
        userService.deleteUserById(id);
        return "redirect:/admin/users";

    }
    @GetMapping("/del/{id}")
    public String delete(@PathVariable(name = "id")  Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }

}
