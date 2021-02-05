package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Question;
import vn.codegym.model.QuestionType;

import java.util.List;

public interface QuestionRepository  extends JpaRepository<Question, Integer> {
    List<Question> findByTitleContaining(String title);
//    List<Question> findByQuestionType(String id);
}
