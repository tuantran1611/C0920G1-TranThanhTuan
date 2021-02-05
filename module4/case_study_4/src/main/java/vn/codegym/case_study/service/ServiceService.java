package vn.codegym.case_study.service;

import vn.codegym.case_study.model.Service;

public interface ServiceService {
    Iterable<Service> findAll();

    Service findById(String id);

    void save(Service service);

    void remove(String id);
}
