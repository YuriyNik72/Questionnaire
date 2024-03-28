package ru.nikitin.entities;


import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Log4j2
@Entity
@Table(name = "answers")
public class Answer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "answer_1")
    private String answer_1;
    @Column(name = "answer_2")
    private String answer_2;
    @Column(name = "answer_3")
    private String answer_3;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name ="question_id")
    private Question question;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;


    public Answer() {
        log.info("конструктор Answer без параметров");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(String answer_1) {
        this.answer_1 = answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return  "Ответ_1= '" + answer_1 + '\'' +
                ", Ответ_2= '" + answer_2 + '\'' +
                ", Ответ_3= '" + answer_3;
    }


        //    @Column(name = "image")
//    private String imagePath;



//    public boolean isEmpty() {
//        if(answer_1.isEmpty()
//                & answer_2.isEmpty()
//                & answer_3.isEmpty()
//        ){
//            return true;
//        }
//        return false;
//    }
}
