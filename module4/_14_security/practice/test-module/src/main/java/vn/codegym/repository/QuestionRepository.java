package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Question;

public interface QuestionRepository  extends JpaRepository<Question, Integer> {
}
