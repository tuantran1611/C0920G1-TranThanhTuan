package vn.codegym.case_study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.case_study.model.Customer;

public interface CustomerService {
    Iterable<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);

    Customer findById(String id);

    void save(Customer customer);

    void remove(String id);

    Page<Customer> findByInputText(String inputSearch, Pageable pageable);
}
