package repository;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;
import connection.MySQLConnection;
import models.AttachService;
import models.Contract;
import models.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository {
    private static final String INSERT_CONTRACT_DETAIL_SQL = "INSERT INTO contract_detail" + "  (contract_id,attach_service_id, quantity) VALUES " +
            " (?,?,?);";

    private static final String INSERT_CONTRACT_DETAIL_SQL_2 = "INSERT INTO contract_detail" + "  (contract_detail_id,contract_id,attach_service_id, quantity) VALUES " +
            " (?,?, ?, ?);";
    private static final String SELECT_CONTRACT_DETAIL = "SELECT * FROM contract_detail";
    private static final String GET_CONTRACT_DETAIL_BY_ID = "SELECT * FROM contract_detail where contract_detail_id = ?";
    private static final String DELETE_CONTRACT_DETAIL_SQL = "delete from contract_detail where contract_detail_id = ?;";

    private AttachServiceRepository attachServiceRepository = new AttachServiceRepository();
    private ContractRepository contractRepository = new ContractRepository();

    public ContractDetailRepository() {
    }

    public void addNewContractDetail(ContractDetail contractDetail){
        try (Connection connection = MySQLConnection.getConnection();){

            if (contractDetail.getContractDetailId().equals("")){
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL_SQL);
                preparedStatement.setString(1,contractDetail.getContractId().getContractId());
                preparedStatement.setString(2,contractDetail.getAttachServiceId().getAttachServiceId());
                preparedStatement.setInt(3,contractDetail.getQuantity());
                preparedStatement.executeUpdate();
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL_SQL_2);
                preparedStatement.setString(1,contractDetail.getContractDetailId());
                preparedStatement.setString(2,contractDetail.getContractId().getContractId());
                preparedStatement.setString(3,contractDetail.getAttachServiceId().getAttachServiceId());
                preparedStatement.setInt(4,contractDetail.getQuantity());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ContractDetail selectContractDetailById(String id){
        ContractDetail contractDetail = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CONTRACT_DETAIL_BY_ID)){
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Contract contract = contractRepository.selectContract(rs.getString("contract_id"));
                AttachService attachService = attachServiceRepository.selectAttachServiceById(rs.getString("attach_service_id"));
                int quantity = rs.getInt("quantity");
                contractDetail = new ContractDetail(id,contract,attachService,quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetail;
    }

    public List<ContractDetail> getAllContractDetail(){
        List<ContractDetail> contractDetailList = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_DETAIL)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String id = rs.getString("contract_detail_id");
                Contract contract = contractRepository.selectContract(rs.getString("contract_id"));
                AttachService attachService = attachServiceRepository.selectAttachServiceById(rs.getString("attach_service_id"));
                int quantity = rs.getInt("quantity");
                contractDetailList.add(new ContractDetail(id,contract,attachService,quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetailList;
    }

    public boolean deleteContractDetail(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CONTRACT_DETAIL_SQL)) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
