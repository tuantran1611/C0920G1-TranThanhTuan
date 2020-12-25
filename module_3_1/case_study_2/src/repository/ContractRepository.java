package repository;

import connection.MySQLConnection;
import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    private static final String INSERT_CONTRACT_SQL = "INSERT INTO contract" + "  (contract_id,contract_start_date, contract_end_date, contract_deposit," +
            " contract_total_money, employee_id, customer_id, service_id) VALUES " +
            " (?,?,?, ?, ?,?,?,?);";

    private static final String INSERT_CONTRACT_SQL_2 = "INSERT INTO contract" + "  (contract_start_date, contract_end_date, contract_deposit," +
            " contract_total_money, employee_id, customer_id, service_id) VALUES " +
            " (?,?, ?, ?,?,?,?);";

    private static final String SELECT_CONTRACT_BY_ID = "select contract_start_date, contract_end_date, contract_deposit, " +
            "contract_total_money, employee_id, customer_id, service_id from contract where contract_id =?";
    private static final String SELECT_ALL_CONTRACT = "select * from contract";
    private static final String DELETE_CONTRACT_SQL = "delete from contract where contract_id = ?;";
    private static final String UPDATE_CONTRACT_SQL = "update contract set contract_start_date = ?, contract_end_date = ?, contract_deposit = ?, " +
            "contract_total_money = ?, employee_id = ?, customer_id = ?, service_id = ? where contract_id = ?";
    private EmployeeRepository employeeRepository = new EmployeeRepository();
    private CustomerRepository customerRepository = new CustomerRepository();
    private ServiceRepository serviceRepository = new ServiceRepository();

    public ContractRepository() {
    }

    public void addContract(Contract contract) {
        try (Connection connection = MySQLConnection.getConnection();
             ) {
            if (contract.getContractId().equals("")){
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_SQL_2);
                preparedStatement.setString(1, contract.getContractStartDate());
                preparedStatement.setString(2, contract.getContractEndDate());
                preparedStatement.setDouble(3, contract.getContractDeposit());
                preparedStatement.setDouble(4, contract.getContractTotalMoney());
                preparedStatement.setString(5, contract.getEmployeeId().getEmployeeId());
                preparedStatement.setString(6, contract.getCustomerId().getCustomerId());
                preparedStatement.setString(7, contract.getServiceId().getServiceId());
                preparedStatement.executeUpdate();
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_SQL);

                preparedStatement.setString(1, contract.getContractId());
                preparedStatement.setString(2, contract.getContractStartDate());
                preparedStatement.setString(3, contract.getContractEndDate());
                preparedStatement.setDouble(4, contract.getContractDeposit());
                preparedStatement.setDouble(5, contract.getContractTotalMoney());
                preparedStatement.setString(6, contract.getEmployeeId().getEmployeeId());
                preparedStatement.setString(7, contract.getCustomerId().getCustomerId());
                preparedStatement.setString(8, contract.getServiceId().getServiceId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Contract selectContract(String id) {
        Contract contract = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String startDate = rs.getString("contract_start_date");
                String endDate = rs.getString("contract_end_date");
                double deposit = rs.getDouble("contract_deposit");
                double totalMoney = rs.getDouble("contract_total_money");
                Employee employee = employeeRepository.selectEmployee(rs.getString("employee_id"));
                Customer customer = customerRepository.selectCustomer(rs.getString("customer_id"));
                Service service = serviceRepository.selectServiceById(rs.getString("service_id"));
                contract = new Contract(id,startDate,endDate,deposit,totalMoney,employee,customer,service);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contract;
    }

    public List<Contract> selectAllContract() {
        List<Contract> contracts = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String contractId = rs.getString("contract_id");
                String startDate = rs.getString("contract_start_date");
                String endDate = rs.getString("contract_end_date");
                double deposit = rs.getDouble("contract_deposit");
                double totalMoney = rs.getDouble("contract_total_money");
                Employee employee = employeeRepository.selectEmployee(rs.getString("employee_id"));
                Customer customer = customerRepository.selectCustomer(rs.getString("customer_id"));
                Service service = serviceRepository.selectServiceById(rs.getString("service_id"));
                contracts.add(new Contract(contractId,startDate,endDate,deposit,totalMoney,employee,customer,service));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contracts;
    }

    public boolean deleteContract(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CONTRACT_SQL)) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateContract(Contract contract) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CONTRACT_SQL)) {
            statement.setString(1, contract.getContractStartDate());
            statement.setString(2, contract.getContractEndDate());
            statement.setDouble(3, contract.getContractDeposit());
            statement.setDouble(4, contract.getContractTotalMoney());
            statement.setString(5, contract.getEmployeeId().getEmployeeId());
            statement.setString(6, contract.getCustomerId().getCustomerId());
            statement.setString(7, contract.getServiceId().getServiceId());
            statement.setString(8, contract.getContractId());
            System.out.println(statement);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
