package repository;

import connection.MySQLConnection;
import models.Customer;
import models.CustomerType;
import services.impl.CustomerService;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer" + "  (customer_id,customer_type_id, customer_name, customer_birthday," +
            " customer_gender, customer_id_card, customer_phone, customer_email, customer_address) VALUES " +
            " (?,?, ?, ?,?,?,?,?,?);";

    private static final String INSERT_CUSTOMER_SQL_2 = "INSERT INTO customer" + "  (customer_type_id, customer_name, customer_birthday," +
            " customer_gender, customer_id_card, customer_phone, customer_email, customer_address) VALUES " +
            " (?, ?, ?,?,?,?,?,?);";

    private static final String SELECT_CUSTOMER_BY_ID = "select customer_type_id, customer_name, customer_birthday, " +
            "customer_gender, customer_id_card, customer_phone, customer_email, customer_address from customer where customer_id =?";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id = ?, customer_name = ?, customer_birthday = ?, " +
            "customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ? where customer_id = ?";

    private CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    public CustomerRepository() {
    }

    public void addCustomer(Customer customer) {
        System.out.println(INSERT_CUSTOMER_SQL);
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);) {
                preparedStatement.setString(1, customer.getCustomerId().substring(3));
                preparedStatement.setString(2, customer.getCustomerTypeId().getCustomerTypeId());
                preparedStatement.setString(3, customer.getCustomerName());
                preparedStatement.setString(4, customer.getCustomerBirthDay());
                preparedStatement.setBoolean(5, customer.getCustomerGender());
                preparedStatement.setString(6, customer.getCustomerIdCard());
                preparedStatement.setString(7, customer.getCustomerPhone());
                preparedStatement.setString(8, customer.getCustomerEmail());
                preparedStatement.setString(9, customer.getCustomerAddress());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            statement.setString(1, customer.getCustomerTypeId().getCustomerTypeId());
            statement.setString(2, customer.getCustomerName());
            statement.setString(3, customer.getCustomerBirthDay());
            statement.setBoolean(4, customer.getCustomerGender());
            statement.setString(5, customer.getCustomerIdCard());
            statement.setString(6, customer.getCustomerPhone());
            statement.setString(7, customer.getCustomerEmail());
            statement.setString(8, customer.getCustomerAddress());
            statement.setString(9, customer.getCustomerId().substring(3));
            System.out.println(statement);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public Customer selectCustomer(String id) {
        Customer customer = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id1 = null;
                if (id.matches("^000[1-9]$")){
                    id1 = ("KH-").concat(id);
                } else if (id.matches("^00[1-9]\\d$")){
                    id1 = ("KH-").concat(id);
                } else if (id.matches("^0[1-9]\\d\\d$")){
                    id1 = ("KH-").concat(id);
                }
                CustomerType customerType = customerTypeRepository.selectTypeNote(rs.getString("customer_type_id"));
                String customerName = rs.getString("customer_name");
                String customerBirthDay = rs.getString("customer_birthday");

//                SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
//                java.util.Date date = null;
//                try {
//                    date = dt.parse(customerBirthDay);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
//                String birthday1 = dt1.format(date);

                boolean customerGender = rs.getBoolean("customer_gender");
                String customerCardId = rs.getString("customer_id_card");
                String customerPhone = rs.getString("customer_phone");
                String customerEmail = rs.getString("customer_email");
                String customerAddress = rs.getString("customer_address");

                customer = new Customer(id1, customerType, customerName, customerBirthDay, customerGender,
                        customerCardId, customerPhone, customerEmail, customerAddress);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    public Customer selectCustomer1(String id) {
        Customer customer = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id1 = null;
                if (id.matches("^000[1-9]$")){
                    id1 = ("KH-").concat(id);
                } else if (id.matches("^00[1-9]\\d$")){
                    id1 = ("KH-").concat(id);
                } else if (id.matches("^0[1-9]\\d\\d$")){
                    id1 = ("KH-").concat(id);
                }
                CustomerType customerType = customerTypeRepository.selectTypeNote(rs.getString("customer_type_id"));
                String customerName = rs.getString("customer_name");
                String customerBirthDay = rs.getString("customer_birthday");

                SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date date = null;
                try {
                    date = dt.parse(customerBirthDay);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
                String birthday1 = dt1.format(date);

                boolean customerGender = rs.getBoolean("customer_gender");
                String customerCardId = rs.getString("customer_id_card");
                String customerPhone = rs.getString("customer_phone");
                String customerEmail = rs.getString("customer_email");
                String customerAddress = rs.getString("customer_address");
                customer = new Customer(id1, customerType, customerName, birthday1, customerGender,
                        customerCardId, customerPhone, customerEmail, customerAddress);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    public List<Customer> selectAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("customer_id");
                String id1 = null;
                if (id.matches("^[1-9]$")){
                    id1 = ("KH-000").concat(id);
                } else if (id.matches("^[1-9]\\d$")){
                    id1 = ("KH-00").concat(id);
                } else if (id.matches("^[1-9]\\d\\d$")){
                    id1 = ("KH-0").concat(id);
                }
                CustomerType customerType = customerTypeRepository.selectTypeNote(rs.getString("customer_type_id"));
                String customerName = rs.getString("customer_name");
                String customerBirthDay = rs.getString("customer_birthday");

                SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date date = null;
                try {
                    date = dt.parse(customerBirthDay);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
                String birthday1 = dt1.format(date);

                boolean customerGender = rs.getBoolean("customer_gender");
                String customerCardId = rs.getString("customer_id_card");
                String customerPhone = rs.getString("customer_phone");
                String customerEmail = rs.getString("customer_email");
                String customerAddress = rs.getString("customer_address");

                customers.add(new Customer(id1, customerType, customerName, birthday1, customerGender,
                        customerCardId, customerPhone, customerEmail, customerAddress));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

    public List<Customer> selectCustomerByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        String query = "{CALL search_customer(?)}";
        try (
                Connection connection = MySQLConnection.getConnection();
                CallableStatement callableStatement = connection.prepareCall(query)) {
                callableStatement.setString(1,name);
                ResultSet rs = callableStatement.executeQuery();
                while (rs.next()){
                    String id = rs.getString("customer_id");
                    String id1 = null;
                    if (id.matches("^[1-9]$")){
                        id1 = ("KH-000").concat(id);
                    } else if (id.matches("^[1-9]\\d$")){
                        id1 = ("KH-00").concat(id);
                    } else if (id.matches("^[1-9]\\d\\d$")){
                        id1 = ("KH-0").concat(id);
                    }
                    CustomerType customerType = customerTypeRepository.selectTypeNote(rs.getString("customer_type_id"));
                    String customerName = rs.getString("customer_name");
                    String customerBirthDay = rs.getString("customer_birthday");

                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
                    java.util.Date date = null;
                    try {
                        date = dt.parse(customerBirthDay);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
                    String birthday1 = dt1.format(date);

                    boolean customerGender = rs.getBoolean("customer_gender");
                    String customerCardId = rs.getString("customer_id_card");
                    String customerPhone = rs.getString("customer_phone");
                    String customerEmail = rs.getString("customer_email");
                    String customerAddress = rs.getString("customer_address");
                    customerList.add(new Customer(id1, customerType, customerName, birthday1, customerGender,
                            customerCardId, customerPhone, customerEmail, customerAddress));
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public boolean deleteCustomer(String id) {
        boolean rowDeleted = false;
        try {
            try (Connection connection = MySQLConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {
                statement.setString(1, id.substring(3));
                System.out.println(statement);
                rowDeleted = statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
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
