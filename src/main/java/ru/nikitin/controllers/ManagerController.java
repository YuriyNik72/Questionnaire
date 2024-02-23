package ru.nikitin.controllers;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.nikitin.entities.Answer;
import ru.nikitin.entities.Question;
import ru.nikitin.repositories.AnswerRepository;
import ru.nikitin.repositories.QuestionRepository;
import ru.nikitin.services.AnswerService;
import ru.nikitin.services.QuestionService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/manager")
@Log4j2
public class ManagerController {

    private QuestionService questionService;
    private AnswerService answerService;
//    private QuestionRepository questionRepository;
//    private AnswerRepository answerRepository;
//    private Question question;

    @Autowired
    public void setQuestionService(QuestionService questionService){
        this.questionService = questionService;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService){this.answerService = answerService;}
//    @Autowired
//    public void setQuestionRepository(QuestionRepository questionRepository){this.questionRepository = questionRepository;}
//    @Autowired
//    public void setAnswerRepository(AnswerRepository answerRepository){this.answerRepository = answerRepository;}
    @GetMapping
    public String managerHome() {
            return "manager-panel";
        }

    @GetMapping("/questions")
    public String showQuestion(Model model) {
        log.info("ManagerController начал работать метод showQuestion");
        List<Question> listQuestions = questionService.listAll();
//        List<Answer> listAnswers = answerService.listAll();
        model.addAttribute("listQuestions", listQuestions);
//        model.addAttribute("listAnswers", listAnswers);
        log.info("ManagerController Отработал метод showQuestion");
        return "manager-panel";
    }

    @RequestMapping("/new")
    public String showNewQuestionPage(Model model) {
        Question question = new Question();
        model.addAttribute("question", question);
        Answer answer = new Answer();
        model.addAttribute("answer", answer);
        return "new_question";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveQuestion(@ModelAttribute("question") Question question, Answer answer) {
        answer.setQuestion(question);
        question.addAnswer(answer);
        questionService.saveQuestion(question);
        return "redirect:/manager/questions";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditQuestionPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_question");
        Question question = questionService.get(id);
        Answer answer = answerService.get(id);
        mav.addObject("question", question);
        mav.addObject("answers", answer);
        return  mav;
//        model.addAttribute("question", questionService.findQuestionById(id));
//        log.info("ManagerController оработал метод editQuestion_question");
//        model.addAttribute("answer", answerService.findAnswerById(id));
//        log.info("ManagerController отработал метод editQuestion_answer");
//        return "edit-manager-panel";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String processQuestionAddForm(@ModelAttribute("question") @Valid @NotNull Question question,  @Valid Answer answer,Long id,
                                         BindingResult theBindingResult
//            , Model model
    ) {
        log.info("ManagerController начал работать метод processQuestionAddForm");

        if (question.getId() == 0 && questionService.getByQuestion(String.valueOf(question)).isEmpty()
//             && answerService.getByAnswer(String.valueOf(answers)).isEmpty()
        ) {
            theBindingResult.addError(new ObjectError("question.id",
                    "Вопрос с таким номером уже существует")); // todo не отображает сообщение
        }
//        if (theBindingResult.hasErrors()) {
//            model.addAttribute("question", questionService.getAllQuestion());
//            model.addAttribute("answer", answerService.getAllAnswer());
//            return "redirect:/manager";
//        }
        answer.setId(id);
        answer.setQuestion(question);
        question.addAnswer(answer);
        questionService.saveQuestion(question);
        return "redirect:/manager/questions";

//        questionService.saveOrUpdate(question);
//        answerService.saveOrUpdate((Answer) answers);
//        log.info("ManagerController отработал метод processQuestionAddForm");
//        return "redirect:/manager/questions";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteQuestion(@PathVariable(name = "id") Long id) {
        questionService.delete(id);
        return "redirect:/manager/questions";
    }

//    @GetMapping("/manager-panel")
//    public String updateOrSave(Model model, Question question, List<Answer> answers) {
//        log.info("ManagerController начал работать метод updateOrSave");
//        model.addAttribute("question", questionService.saveOrUpdate(question));
//        model.addAttribute("answer", answerService.saveOrUpdate((Answer)answers));
//        log.info("отработал метод updateOrSave");
//        return "redirect:/manager-panel";
//        }
//
//
//    @PostMapping("/del/{id}")
//    public String deleteById(@PathVariable(name = "id")  Long id) {
//        if (questionService.findQuestionById(id).equals(id)) {
//            questionService.deleteQuestionById(questionService.findQuestionById(id).getId());
//            return "redirect:/manager-panel";
//        }
//        answerService.deleteAnswerById(id);
//        questionService.deleteQuestionById(id);
//
//        return "redirect:/manager/questions";
//
//    }
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String delete(@PathVariable(name = "id")  Long id) {
//        questionService.delete(id);
////        answerService.deleteAnswerById(id);
//        return "redirect:/manager/questions";
//    }
//    @GetMapping("/add")
//    public String AddForm(){
//        log.info("ManagerController Метод addForm");
//        return "formAddQuestion";
//    }
//    @PostMapping("/add")
//    public String addQuestion(AddFormQuestionController form, Model model) {
//        log.info("ManagerController метод addQuestion");
//        Question questions = questionRepository.findOneByQuestion(String.valueOf(question));
//        if(questions == null){
//
//            model.addAttribute("question",questionRepository.save(form.toQuestion()));
//
//            model.addAttribute("answer", answerRepository.save(form.toAnswer()));
//            return "redirect:/manager/questions";
//        }
//        throw new RuntimeException("Такой вопрос уже присутствует");
//
//    }
}
