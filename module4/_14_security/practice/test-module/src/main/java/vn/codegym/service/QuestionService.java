package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Question;

public interface QuestionService {
    Iterable<Question> findAll();
    Page<Question> findAll(Pageable pageable);

    Question findById(int id);

    void save(Question question);

    void remove(int id);

//    Page<Question> findByInputText(String inputSearch, Pageable pageable);
}
