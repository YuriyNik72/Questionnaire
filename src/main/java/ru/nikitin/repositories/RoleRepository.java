package ru.nikitin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitin.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

//    Role findOneByName(String roleEmployee);
    Role findOneByName(String role);
}
