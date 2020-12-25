package services.impl;

import models.Customer;
import models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee) throws SQLException;

    public Employee selectEmployee(String id);

    public List<Employee> selectAllEmployee();

    public boolean deleteEmployee(String id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;

    public List<Employee> selectEmployeeByName(String name);
}
