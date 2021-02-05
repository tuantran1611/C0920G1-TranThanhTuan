package vn.codegym.case_study.service;

import vn.codegym.case_study.model.ContractDetail;

public interface ContractDetailService {
    Iterable<ContractDetail> findAll();

    ContractDetail findById(Long id);

    void save(ContractDetail contractDetail);

    void remove(Long id);
}
