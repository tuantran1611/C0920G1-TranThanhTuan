package services;

import models.ContractDetail;
import repository.ContractDetailRepository;
import services.impl.ContractDetailService;

import java.sql.SQLException;
import java.util.List;

public class ContractDetailServiceImpl implements ContractDetailService {

    ContractDetailRepository contractDetailRepository = new ContractDetailRepository();

    @Override
    public ContractDetail selectContractDetailById(String id) {
        return contractDetailRepository.selectContractDetailById(id);
    }

    @Override
    public List<ContractDetail> getAllContractDetail() {
        return contractDetailRepository.getAllContractDetail();
    }

    @Override
    public void addNewContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.addNewContractDetail(contractDetail);
    }

    @Override
    public boolean deleteContractDetail(String id) throws SQLException {
        return contractDetailRepository.deleteContractDetail(id);
    }
}
