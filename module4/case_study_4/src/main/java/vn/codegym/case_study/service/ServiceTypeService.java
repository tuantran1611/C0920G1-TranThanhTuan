package vn.codegym.case_study.service;

import vn.codegym.case_study.model.ServiceType;

public interface ServiceTypeService {
    Iterable<ServiceType> findAll();
}
