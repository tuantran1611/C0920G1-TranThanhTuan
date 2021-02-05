package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idQuestionType;

    private String name;

    @OneToMany(mappedBy = "questionType")
    private Set<Question> questionSet;

    public QuestionType() {
    }

    public int getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(int idQuestionType) {
        this.idQuestionType = idQuestionType;
    }

    public Set<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
