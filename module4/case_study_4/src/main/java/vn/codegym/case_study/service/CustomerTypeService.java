package vn.codegym.case_study.service;

import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.Customer;
import vn.codegym.case_study.model.CustomerType;

public interface CustomerTypeService {
    Iterable<CustomerType> findAll();
}
