package vn.codegym.case_study.service;

import vn.codegym.case_study.model.Customer;
import vn.codegym.case_study.model.User;

public interface UserService {
    Iterable<User> findAll();
    void save(User user);
    User findByUsername(String name);
}
