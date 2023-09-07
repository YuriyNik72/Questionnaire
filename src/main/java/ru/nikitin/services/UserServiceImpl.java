package ru.nikitin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitin.entities.SystemUser;
import ru.nikitin.entities.User;
import ru.nikitin.repositories.RoleRepository;
import ru.nikitin.repositories.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl extends UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

//    @Override
    public boolean save(SystemUser systemUser) {
        User user = new User();
        if (findByUsername(systemUser.getUserName()) != null) {
            return false;
        }
        user.setUsername(systemUser.getUserName());
        user.setEmail(systemUser.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findOneByName("ROLE_EMPLOYEE")));

        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>)userRepository.findAll();
    }
}
