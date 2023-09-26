package ru.nikitin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.nikitin.entities.Question;
import ru.nikitin.entities.User;
import ru.nikitin.repositories.QuestionRepository;
import ru.nikitin.services.QuestionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private QuestionService questionService;

    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    @Autowired
    public void setQuestionService(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping
    public String managerHome() {
            return "manager-panel";
        }

    @GetMapping("/questions")
    public String showQuestion(Model model) {
        List<Question> questions = questionService.getAllQuestion();
        model.addAttribute("questions", questions);
        return "manager-panel";
    }

    @GetMapping("/edit/{id}")
    public String editQuestion(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("question", questionService.findQuestionById(id));
        return "edit-manager-panel";
    }

    @GetMapping("/manager-panel")
    public String updateQuestion(Model model, Question question) {
        model.addAttribute("question", questionService.saveOrUpdate(question));
        return "redirect:manager-panel";
        }

    @PostMapping("/manager/{id}")
    public String processQuestionAddForm(@ModelAttribute("question") @Valid Question question, BindingResult theBindingResult, Model model) {
        if (question.getId() == 0 && questionService.getByQuestion(String.valueOf(question)).isEmpty()) {
            theBindingResult.addError(new ObjectError("question.id",
                    "Вопрос с таким номером уже существует")); // todo не отображает сообщение
        }
        if (theBindingResult.hasErrors()) {
            model.addAttribute("question", questionService.getAllQuestion());
            return "redirect:/manager";
        }
        questionService.saveOrUpdate(question);
        return "redirect:/manager";
    }

}
