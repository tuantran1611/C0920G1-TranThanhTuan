package vn.codegym.case_study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.case_study.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    Page<Customer> findByCustomerNameContaining(String name, Pageable pageable);
}
