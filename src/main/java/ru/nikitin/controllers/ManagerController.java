package ru.nikitin.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.nikitin.entities.Answer;
import ru.nikitin.entities.Category;
import ru.nikitin.entities.Question;
import ru.nikitin.services.AnswerService;
import ru.nikitin.services.CategoryService;
import ru.nikitin.services.QuestionService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/manager")
@Log4j2
public class ManagerController {

    private QuestionService questionService;
    private AnswerService answerService;
    private CategoryService categoryService;

    @Autowired
    public void setQuestionService(QuestionService questionService){
        this.questionService = questionService;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService){this.answerService = answerService;}

    @Autowired
    public  void setCategoryService(CategoryService categoryService){this.categoryService = categoryService;}
    @GetMapping
    public String managerHome() {
            return "manager-panel";
        }

    @GetMapping("/questions")
    public String showQuestion(Model model) {
        log.info("ManagerController начал работать метод showQuestion");
        List<Question> listQuestions = questionService.listAll();
        model.addAttribute("listQuestions", listQuestions);
//        model.addAttribute("category", categoryService.getAllCategories());
        log.info("ManagerController Отработал метод showQuestion");
        return "manager-panel";
    }

    @RequestMapping("/new")
    public String showNewQuestionPage(Model model) {
        Question question = new Question();
        model.addAttribute("question", question);
        Answer answer = new Answer();
        model.addAttribute("answer", answer);
        model.addAttribute("category", categoryService.getAllCategories());
        return "new_question";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveQuestion(@ModelAttribute("question") Question question, Answer answer, Category category) {
        answer.setQuestion(question);
        question.addAnswer(answer);
        question.setCategory(category);
        questionService.saveQuestion(question);
        return "redirect:/manager/questions";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditQuestionPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_question");
        Question question = questionService.get(id);
        Answer answer = answerService.get(id);
        List<Category> category = categoryService.getAllCategories();
        mav.addObject("question", question);
        mav.addObject("answers", answer);
        mav.addObject("categories", category);
        return  mav;

    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public String processQuestionAddForm(@ModelAttribute("question") @Valid Question question, BindingResult theBindingResult) {
        public String processQuestionAddForm(@ModelAttribute("question") @Valid Question question, BindingResult theBindingResult
                                         ,Model model, Answer answer
//            , @RequestParam("file") MultipartFile file
    ) {
        log.info("ManagerController начал работать метод processQuestionAddForm");

        if (question.getId() == 0 && questionService.isQuestionWithQuestionNameExists(question.getQuestionName())
//                && questionService.getByQuestion(String.valueOf(question)).isEmpty()
        ) {
            theBindingResult.addError(new ObjectError("question",
                    "Вопрос с таким названием уже существует")); // todo не отображает сообщение
        }
        if (theBindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            model.addAttribute("question", questionService.listAll());
            model.addAttribute("answer", answerService.listAll());
            return "redirect:/edit_question";
        }
            // TODO доделать File Service
//        if (!file.isEmpty()) {
//            String pathToSavedFile = fileSaverService.saveFile(file);
//            QuestionFile questionfile = new QuestionFile();
//            questionfile.setPath(pathToSavedFile);
//            questionfile.setQuestion(question);
//            question.addFile(questionFile);
//        }
            answer.setQuestion(question);
            question.addAnswer(answer);
            questionService.saveQuestion(question);
        return "redirect:/manager/questions";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteQuestion(@PathVariable(name = "id") Long id) {
        questionService.delete(id);
        return "redirect:/manager/questions";
    }


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
//    public String addQuestion(ThemesController form, Model model) {
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
