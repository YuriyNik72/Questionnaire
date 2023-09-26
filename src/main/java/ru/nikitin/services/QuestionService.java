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
        return (List<Question>)questionRepository.findAll();
    }

    public Question getByQuestion(String question) {
        return questionRepository.findOneByQuestion(question);
    }

//    public Question getQuestionById(Long id) {
//        Optional<Question> question = questionRepository.findById(id);
//        if (question.isPresent()) {
//            return question.get();
//        }
//        return null;
//    }

    public Question findQuestionById(Long id) {
        return questionRepository.findQuestionById(id);
    }

//    public Page<Question> findAll(int size, int num) {
//        return null;
//    }
//
//    public Page<Question> getFiltered(String filter, int size, int num) {
//        return null;
//    }

    public Question saveOrUpdate(Question question) {
            return questionRepository.save(question);
    }

    public void deleteQuestionById(Long id) {
    }

//    public boolean isEmpty(boolean empty) {
//        return true;
//    }

//    public boolean isEmpty(boolean empty) {
//        Optional<Question> question = questionRepository.findOneByQuestion();
//        if(question.isEmpty()){
//            return true;
//        }
//        return false;
//    }
}
