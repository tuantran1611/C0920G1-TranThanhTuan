package vn.codegym.case_study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.case_study.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByUser_Id(Long id);
    Page<Employee> findByEmployeeNameContaining(String name, Pageable pageable);

//    @Query("select e from employee e where e.employeeName =:input and e.employeeBirthDay >= "2000" ")
//    Page<Employee> findByName2(@Param("input") String name, Pageable pageable);

}
