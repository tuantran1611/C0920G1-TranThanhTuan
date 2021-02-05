package vn.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idQuestion;

    @NotNull(message = "Please input title")
    @Size(min = 5 , max = 100)
    private String title;

    private String question;

    @NotNull(message = "Please input content")
    @Size(min = 10, max = 500)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "id_question_type", referencedColumnName = "idQuestionType")
    private QuestionType questionType;

    @NotNull(message = "Please choose day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_create;

    @ManyToOne
    @JoinColumn(name = "user_create", referencedColumnName = "idUser")
    private User userCreate;

//    @ManyToOne
//    @JoinColumn(name = "user_feedback" , referencedColumnName = "id")
//    private User userFeedBack;


    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }

    public User getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(User userCreate) {
        this.userCreate = userCreate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;
}
