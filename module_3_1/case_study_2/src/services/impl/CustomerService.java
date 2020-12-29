package services.impl;

import models.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(String id);

    public Customer selectCustomer1(String id);

    public List<Customer> selectAllCustomer();

    public boolean deleteCustomer(String id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;

    public List<Customer> selectCustomerByName(String name);
}
