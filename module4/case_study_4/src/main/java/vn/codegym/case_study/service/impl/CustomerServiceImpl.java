package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.Customer;
import vn.codegym.case_study.repository.CustomerRepository;
import vn.codegym.case_study.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.getOne(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(String id) {
        Customer customer = customerRepository.getOne(id);
        customerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findByInputText(String inputSearch, Pageable pageable) {
        return customerRepository.findByCustomerNameContaining(inputSearch, pageable);
    }
}
