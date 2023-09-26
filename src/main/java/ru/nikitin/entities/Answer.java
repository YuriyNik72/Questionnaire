package ru.nikitin.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "answers")
@Data
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

//    @ManyToOne
//    @JoinColumn(name="question_id")
//    private Question question;

    public Answer(String answer_1, String answer_2, String answer_3){
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;

    }

    public Answer() {
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer_1='" + answer_1 + '\'' +
                ", answer_2='" + answer_2 + '\'' +
                ", answer_3='" + answer_3 + '\'' +
//                ", question=" + question +
                '}';
    }
    //    @Column(name = "image")
//    private String imagePath;


//
//    @Column(name = "create_at")
//    @Temporal(TemporalType.DATE)
//    private Date createAt;
}
