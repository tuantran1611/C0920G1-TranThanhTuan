package vn.codegym.case_study.service;

import vn.codegym.case_study.model.Customer;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(String id);

    void save(Customer customer);

    void remove(String id);
}
