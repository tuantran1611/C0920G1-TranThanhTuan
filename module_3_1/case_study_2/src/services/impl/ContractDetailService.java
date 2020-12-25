package services.impl;

import models.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface ContractDetailService {
    public ContractDetail selectContractDetailById(String id);
    public List<ContractDetail> getAllContractDetail();
    public void addNewContractDetail(ContractDetail contractDetail);
    public boolean deleteContractDetail(String id) throws SQLException;
}
