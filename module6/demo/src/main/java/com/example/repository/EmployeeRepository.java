package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findAllByLastNameContaining(Pageable pageable, String name);

    @Query("SELECT DISTINCT e.email FROM Employee e")
    List<String> findDistinctEmail();
}
