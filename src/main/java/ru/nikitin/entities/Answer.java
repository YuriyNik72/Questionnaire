package ru.nikitin.entities;


import lombok.*;
import lombok.extern.log4j.Log4j2;
import javax.persistence.*;
import java.util.Calendar;


@Setter
@Getter
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


    @Column(name = "otvet_1")
    private Integer otvet_1=0;


    @Column(name = "answer_2")
    private String answer_2;

    @Column(name = "otvet_2")
    private Integer otvet_2=0;

    @Column(name = "answer_3")
    private String answer_3;

    @Column(name = "otvet_3")
    private Integer otvet_3=0;


    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name ="question_id")
    private Question question;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Calendar createAt;

//    @Column(name="type")
//    private String type;
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public Answer() {log.info("конструктор Answer без параметров");
    }

    public Calendar getCreateAt() {
        return Calendar.getInstance();
    }

    public void setCreateAt(Calendar createAt) {
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
