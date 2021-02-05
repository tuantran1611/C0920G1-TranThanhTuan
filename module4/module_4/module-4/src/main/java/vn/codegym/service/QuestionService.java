package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Question;
import vn.codegym.model.QuestionType;

import java.util.List;

public interface QuestionService {
    Iterable<Question> findAll();
    Page<Question> findAll(Pageable pageable);

    Question findById(int id);

    void save(Question question);

    void remove(int id);

    List<Question> findByTitle(String title);

//    List<Question> findByQuestionType(String id);

//    Page<Question> findByInputText(String inputSearch, Pageable pageable);
}
