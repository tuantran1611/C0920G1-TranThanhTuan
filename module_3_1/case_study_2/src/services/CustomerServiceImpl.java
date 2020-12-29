package services;

import models.Customer;
import repository.CustomerRepository;
import services.impl.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        customerRepository.addCustomer(customer);
    }

    @Override
    public Customer selectCustomer(String id) {
        return customerRepository.selectCustomer(id);
    }

    @Override
    public Customer selectCustomer1(String id) {
        return customerRepository.selectCustomer1(id);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> selectCustomerByName(String name) {
        return customerRepository.selectCustomerByName(name);
    }
}
