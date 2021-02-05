package vn.codegym.case_study.service;

import vn.codegym.case_study.model.Division;
import vn.codegym.case_study.model.Employee;

public interface DivisionService {
    Iterable<Division> findAll();
}
