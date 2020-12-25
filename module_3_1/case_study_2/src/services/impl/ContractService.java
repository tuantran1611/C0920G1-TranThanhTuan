package services.impl;

import models.Contract;
import models.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ContractService {
    public void addContract(Contract contract) throws SQLException;

    public Contract selectContract(String id);

    public List<Contract> selectAllContract();

    public boolean deleteContract(String id) throws SQLException;

    public boolean updateContract(Contract contract) throws SQLException;

}
