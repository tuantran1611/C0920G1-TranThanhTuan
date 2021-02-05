package com.codegym.createcart.service;

import com.codegym.createcart.model.Product;
import com.codegym.createcart.model.User;

public interface UserService {
    Iterable<User> findAll();
    void save(User user);
}
