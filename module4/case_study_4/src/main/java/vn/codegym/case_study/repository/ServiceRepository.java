package vn.codegym.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.Service;

public interface ServiceRepository extends JpaRepository<Service,String> {
}
