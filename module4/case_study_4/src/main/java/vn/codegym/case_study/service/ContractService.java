package vn.codegym.case_study.service;

import vn.codegym.case_study.model.Contract;

public interface ContractService {
    Iterable<Contract> findAll();

    Contract findById(Long id);

    void save(Contract contract);

    void remove(Long id);
}
