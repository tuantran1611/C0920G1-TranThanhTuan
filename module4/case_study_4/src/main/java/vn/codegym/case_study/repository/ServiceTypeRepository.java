package vn.codegym.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType,String> {
}
