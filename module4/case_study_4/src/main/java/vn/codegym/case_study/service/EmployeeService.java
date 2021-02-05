package vn.codegym.case_study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.case_study.model.Employee;

public interface EmployeeService {
    Iterable<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Employee findById(String id);

    void save(Employee employee);

    void remove(String id);

    Employee findByUser_id(Long id);

    Page<Employee> findByInputText(String inputSearch, Pageable pageable);
}
