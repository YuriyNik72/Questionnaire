package ru.nikitin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitin.entities.Answer;
import ru.nikitin.repositories.AnswerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    private AnswerRepository repoa;

    @Autowired
    public void setAnswerRepository(AnswerRepository repoa) {
        this.repoa = repoa;
    }

    public List<Answer> listAll() {
        return repoa.findAll();
    }

    public Answer get(Long id){
        return repoa.findById(id).get();
    }


//    public Answer getAnswerById(Long id) {
//        Optional<Answer> answer = repoa.findById(id);
//        return answer.orElse(null);
//    }
//    public Answer findAnswerById(Long id) {
//        Optional<Answer> answer = repoa.findById(id);
////        return answer.orElse(null);
//        return repoa.findAnswerById(id);
//    }
//
    public Answer saveOrUpdate(Answer answers) {
        return repoa.save(answers);
    }

//
//
//    public void deleteAnswerById(Long id) {
//        repoa.deleteById(repoa.findAnswerById(id).getId());
//    }
}
