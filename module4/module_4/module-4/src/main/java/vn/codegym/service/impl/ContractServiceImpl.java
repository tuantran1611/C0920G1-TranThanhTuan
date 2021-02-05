//package vn.codegym.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import vn.codegym.model.Contract;
//import vn.codegym.repository.ContractRepository;
//import vn.codegym.service.ContractService;
//
//import javax.validation.constraints.NotNull;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class ContractServiceImpl implements ContractService {
//
//    @Autowired
//    ContractRepository contractRepository;
//
//    @Override
//    public Iterable<Contract> findAll() {
//        return contractRepository.findAll();
//    }
//
//    @Override
//    public Page<Contract> findAll(Pageable pageable) {
//        return contractRepository.findAll(pageable);
//    }
//
//    @Override
//    public Contract findById(String id) {
//        return contractRepository.getOne(id);
//    }
//
//    @Override
//    public void save(Contract contract) {
//        contractRepository.save(contract);
//    }
//
//    @Override
//    public void remove(String id) {
//        contractRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Contract> findByCustomer_NameCusContainingOrIdContractContaining(String customer_nameCus, String idContract) {
//        return contractRepository.findByCustomer_NameCusContainingOrIdContractContaining(customer_nameCus,idContract);
//    }
//}
