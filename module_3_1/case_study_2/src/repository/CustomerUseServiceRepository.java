package repository;

import connection.MySQLConnection;
import models.*;
import services.AttachServiceServiceImpl;
import services.ContractDetailServiceImpl;
import services.ContractServiceImpl;
import services.ServiceServiceImpl;
import services.impl.AttachServiceService;
import services.impl.ContractDetailService;
import services.impl.ContractService;
import services.impl.ServiceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUseServiceRepository {
    private static final String SELECT_ALL_CUSTOMER = "select customer.customer_type_id, customer.customer_name, customer.customer_id_card, customer.customer_phone, customer.customer_address, contract.contract_id, contract.contract_end_date, contract_detail.contract_detail_id, service.service_id, attach_service.attach_service_id from contract " +
            "left join customer on customer.customer_id = contract.customer_id " +
            "left join service on contract.service_id = service.service_id\n" +
            "left join contract_detail on contract.contract_id = contract_detail.contract_detail_id " +
            "left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id " +
            "where contract.contract_end_date < now();";

    ContractService contractService = new ContractServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();
    ContractDetailService contractDetailService = new ContractDetailServiceImpl();
    AttachServiceService attachServiceService = new AttachServiceServiceImpl();

    public CustomerUseServiceRepository() {
    }

    public List<CustomerUseService> selectAllCustomerUseService(){
        List<CustomerUseService> customerUseServiceList = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)){

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String cusName = rs.getString("customer_name");
                String cusAddress = rs.getString("customer_address");
                Contract contract = contractService.selectContract(rs.getString("contract_id"));
                Service service = serviceService.getServiceById(rs.getString("service_id"));
                ContractDetail contractDetail = contractDetailService.selectContractDetailById(rs.getString("contract_detail_id"));
                AttachService attachService = attachServiceService.selectAttachServiceById(rs.getString("attach_service_id"));
                customerUseServiceList.add(new CustomerUseService(cusName,cusAddress,contract,service,contractDetail,attachService));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerUseServiceList;
    }
}
