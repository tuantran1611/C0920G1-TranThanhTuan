package vn.codegym.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.CustomerType;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, String> {
}
