package vn.codegym.case_study.service;

import vn.codegym.case_study.model.Role;

public interface RoleService {
    Iterable<Role> findAll();

    Role findById(Long id);
}
