package ru.nikitin.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nikitin.entities.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
