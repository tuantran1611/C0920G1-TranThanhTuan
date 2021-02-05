package vn.codegym.service;

import vn.codegym.model.QuestionType;

public interface QuestionTypeService {
    Iterable<QuestionType> findAll();
    QuestionType findById(int id);
}
