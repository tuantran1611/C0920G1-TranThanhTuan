package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.Division;
import vn.codegym.case_study.repository.DivisionRepository;
import vn.codegym.case_study.service.DivisionService;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;
    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }
}
