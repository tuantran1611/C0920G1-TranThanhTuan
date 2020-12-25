package repository;

import connection.MySQLConnection;
import models.CustomerType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository {
    private static final String SELECT_CUSTOMER_TYPE = "SELECT * FROM customer_type";
    private static final String GET_CUSTOMER_TYPE_BY_ID = "SELECT * FROM customer_type where customer_type_id = ?";

    public CustomerTypeRepository() {
    }

    public CustomerType selectTypeNote(String id) {
        CustomerType customerType = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_TYPE_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("customer_type_name");
                customerType = new CustomerType(id, name);
            }
            connection.close();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return customerType;
    }
    public List<CustomerType> selectAllCustomerType() {
        List<CustomerType> customerTypes = new ArrayList<>();
        try(Connection connection = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString("customer_type_id");
                String name = rs.getString("customer_type_name");
                customerTypes.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypes;
    }
}
