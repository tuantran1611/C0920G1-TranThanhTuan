package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.Employee;
import vn.codegym.case_study.repository.EmployeeRepository;
import vn.codegym.case_study.repository.UserRepository;
import vn.codegym.case_study.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findByUser_id(Long id) {
        return employeeRepository.findByUser_Id(id);
    }

    @Override
    public Page<Employee> findByInputText(String inputSearch, Pageable pageable) {
        return employeeRepository.findByEmployeeNameContaining(inputSearch,pageable);
    }
}
