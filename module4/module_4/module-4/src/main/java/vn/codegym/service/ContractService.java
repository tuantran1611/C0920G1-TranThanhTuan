//package vn.codegym.service;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import vn.codegym.model.Contract;
//
//import javax.validation.constraints.NotNull;
//import java.util.Date;
//import java.util.List;
//
//public interface ContractService {
//    Iterable<Contract> findAll();
//    Page<Contract> findAll(Pageable pageable);
//
//    Contract findById(String id);
//
//    void save(Contract contract);
//
//    void remove(String id);
//
//    List<Contract> findByCustomer_NameCusContainingOrIdContractContaining(String customer_nameCus, String idContract);
//}
