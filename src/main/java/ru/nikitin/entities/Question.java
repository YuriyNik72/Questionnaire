package ru.nikitin.entities;

import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Log4j2
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "question")
    private String questionName;

    @OneToMany(mappedBy = "question", cascade=CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();

    @ManyToOne()
    @NotNull(message = "категория не выбрана")
    @JoinColumn(name = "category_id")
    private Category category;

    public Question() {
        log.info("конструктор Question без параметров");
    }

    public Question(String questionName, List<Answer> answers, Category category) {
        this.questionName = questionName;
        this.answers = answers;
        this.category = category;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
    return this.answers;
    }

    public Category getCategory() {
    return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isEmpty() {
        if(questionName.isEmpty()){
            return true;
        }
        return false;
    }
    public void addAnswer(Answer answer) {
        if (answers == null) {
            answers = new ArrayList<>();
        }
        answers.add(answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionName='" + questionName + '\'' +
                ", answers=" + answers +
                ", category=" + category +
                '}';
    }
}
