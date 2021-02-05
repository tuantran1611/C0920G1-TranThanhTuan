//package vn.codegym.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import vn.codegym.model.Contract;
//
//import javax.validation.constraints.NotNull;
//import java.util.Date;
//import java.util.List;
//
//public interface ContractRepository extends JpaRepository<Contract, String> {
//    List<Contract> findByCustomer_NameCusContainingOrIdContractContaining(String customer_nameCus, String idContract);
//}
