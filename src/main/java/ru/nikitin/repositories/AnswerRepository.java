package ru.nikitin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitin.entities.Answer;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
