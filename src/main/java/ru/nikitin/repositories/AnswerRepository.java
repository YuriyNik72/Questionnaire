package ru.nikitin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitin.entities.Answer;

import java.util.List;

@Repository
public interface AnswerRepository extends
//        CrudRepository
        JpaRepository<Answer, Long> {

//    Answer findAnswerById(Long id);
//    List<Answer> findAll();
//    @Override
//    Answer save(Answer answer);
//    default Answer save(){
//        String answer_1 = null;
//        String answer_2 = null;
//        String answer_3 = null;
//        Long id = 0l;
//        return new Answer(answer_1, answer_2, answer_3, id);
//    }
//    @Override
//    <S extends Answer> S save(S entity);


}
