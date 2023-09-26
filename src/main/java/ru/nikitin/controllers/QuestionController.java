package ru.nikitin.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nikitin.entities.Answer;
import ru.nikitin.entities.Question;
import ru.nikitin.repositories.AnswerRepository;
import ru.nikitin.repositories.QuestionRepository;
import ru.nikitin.services.QuestionService;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    public QuestionController(QuestionService questionService, QuestionRepository questionRepository, AnswerRepository answerRepository){
        this.questionService = questionService;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;

    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public String QuestionsForm(){
        return "manager-panel";
    }

    @PostMapping
    public String processSaveQuestionAndAnswer(Question question, Answer answer){
        questionRepository.save(question);
        answerRepository.save(answer);
        return "redirect:/manager";
    }
//    @GetMapping("")
//    public String questionsPage(Model model) {
//        List<Question> allQuestion = questionService.getAllQuestion();
//        model.addAttribute("question", allQuestion);
//        return "question-page";
//    }

}
