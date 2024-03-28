package ru.nikitin.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitin.entities.Question;
import ru.nikitin.repositories.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private QuestionRepository repoq;

    @Autowired
    public void setQuestionRepository(QuestionRepository repoq) {
        this.repoq = repoq;
       
    }
    public List<Question> listAll() {
        return repoq.findAll();
    }

    public Question saveQuestion(Question question) {
        repoq.save(question);
        return question;
    }
    public Question get(Long id){
        return repoq.findById(id).get();
    }

    public void delete(Long id){
        repoq.deleteById(id);
    }

    public Question getByQuestion(String questionName) {
    return repoq.findOneByQuestionName(questionName);
    }

    public boolean isQuestionWithQuestionNameExists(String questionName) {
        return repoq.findOneByQuestionName(questionName) != null;
    }

//
//    public Question getQuestionById(Long id) {
//        Optional<Question> question = repoq.findById(id);
//        if (question.isPresent()) {
//            return question.get();
//        }
//        return null;
//    }
//
//    public Question findQuestionById(Long id) {
//        return repoq.findQuestionById(id);
//    }
////
////    public Page<Question> findAll(int size, int num) {
////        return null;
////    }
////
////    public Page<Question> getFiltered(String filter, int size, int num) {
////        return null;
////    }
//
//    public Question saveOrUpdate(Question question) {
//            return  repoq.save(question);
//    }
//
//    public void deleteQuestionById(Long id) {
//        repoq.deleteById(repoq.findQuestionById(id).getId());
//    }

}
