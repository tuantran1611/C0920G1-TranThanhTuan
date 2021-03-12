package com.example.service;

import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findAllByName(Pageable pageable,String name);

    Employee findById(Long id);

    Employee save(Employee employee);

    void remove(Long id);
}
