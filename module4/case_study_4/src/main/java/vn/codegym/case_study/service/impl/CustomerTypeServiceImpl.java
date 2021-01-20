package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.CustomerType;
import vn.codegym.case_study.repository.CustomerTypeRepository;
import vn.codegym.case_study.service.CustomerTypeService;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
