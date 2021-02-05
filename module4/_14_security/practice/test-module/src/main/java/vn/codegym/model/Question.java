package vn.codegym.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idQuestion;

    private String title;

    private String question;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "id_question_type", referencedColumnName = "idQuestionType")
    private QuestionType questionType;

    private Date date_create;

    @ManyToOne
    @JoinColumn(name = "user_create", referencedColumnName = "idUser")
    private User userCreate;

//    @ManyToOne
//    @JoinColumn(name = "user_feedback" , referencedColumnName = "id")
//    private User userFeedBack;

    private int status;
}
