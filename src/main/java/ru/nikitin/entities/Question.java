package ru.nikitin.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Data
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String question;

    @ManyToMany
    @JoinTable(name = "question_answers", joinColumns = @JoinColumn(name = "question_id"),
    inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private Collection<Answer> answer;


    public Question() {
    }

    public Question(String question, Collection<Answer> answer){
        this.question = question;
        this.answer = answer;
    }
    public Question(String question){
        this.question = question;
    }
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }

    public boolean isEmpty() {
        if(question.isEmpty()){
            return true;
        }
        return false;
    }

}
