package com.codegym.createcart.service.impl;

import com.codegym.createcart.model.Role;
import com.codegym.createcart.repository.RoleRepository;
import com.codegym.createcart.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }
}
