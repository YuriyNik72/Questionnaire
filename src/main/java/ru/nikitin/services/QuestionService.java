package ru.nikitin.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitin.entities.Question;
import ru.nikitin.repositories.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;


    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
       
    }

    public List<Question> getAllQuestion() {
        List<Question> questions = questionRepository.findAll();
        return questions;
    }

    public Question getQuestionById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        }
        return null;
    }

    public Question findById(Long id) {
        return null;
    }

//    public Page<Question> findAll(int size, int num) {
//        return null;
//    }
//
//    public Page<Question> getFiltered(String filter, int size, int num) {
//        return null;
//    }

    public void saveOrUpdate(Question question) {
    }

    public void deleteById(long id) {
    }
}
