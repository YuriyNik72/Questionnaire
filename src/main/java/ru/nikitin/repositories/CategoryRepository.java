package ru.nikitin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nikitin.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
