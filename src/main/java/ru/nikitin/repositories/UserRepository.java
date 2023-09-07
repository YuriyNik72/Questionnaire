package ru.nikitin.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitin.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUsername(String username);

    User findUserByEmail(String email);
    User findUserById (Long id);
    void deleteById(Long id);

     @Override
     User save(User user);

}
