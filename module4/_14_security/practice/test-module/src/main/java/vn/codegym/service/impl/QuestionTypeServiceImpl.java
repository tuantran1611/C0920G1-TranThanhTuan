package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.QuestionType;
import vn.codegym.repository.QuestionTypeRepository;
import vn.codegym.service.QuestionTypeService;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public Iterable<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public QuestionType findById(int id) {
        return questionTypeRepository.getOne(id);
    }
}
