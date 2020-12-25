package services;

import models.Contract;
import repository.ContractRepository;
import services.impl.ContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractServiceImpl implements ContractService {

    ContractRepository contractRepository = new ContractRepository();

    @Override
    public void addContract(Contract contract) throws SQLException {
     contractRepository.addContract(contract);
    }

    @Override
    public Contract selectContract(String id) {
        return contractRepository.selectContract(id);
    }

    @Override
    public List<Contract> selectAllContract() {
        return contractRepository.selectAllContract();
    }

    @Override
    public boolean deleteContract(String id) throws SQLException {
        return contractRepository.deleteContract(id);
    }

    @Override
    public boolean updateContract(Contract contract) throws SQLException {
        return contractRepository.updateContract(contract);
    }
}
