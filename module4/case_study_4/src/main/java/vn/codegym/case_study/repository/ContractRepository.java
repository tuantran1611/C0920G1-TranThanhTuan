package vn.codegym.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.Contract;

import java.util.Date;
import java.util.List;

public interface ContractRepository extends JpaRepository<Contract,Long> {
//    List<Contract> findContractsByContractEndDateBeforeAnd(Date date);
}
