package repository;

import connection.MySQLConnection;
import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + "  (employee_id,employee_name, employee_birthday, employee_id_card," +
            " employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username) VALUES " +
            " (?,?,?, ?, ?,?,?,?,?,?,?,?)";

    private static final String INSERT_EMPLOYEE_SQL_2 = "INSERT INTO employee" + "  (employee_name, employee_birthday, employee_id_card," +
            " employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username) VALUES " +
            " (?,?, ?, ?,?,?,?,?,?,?,?)";

    private static final String SELECT_EMPLOYEE_BY_ID = "select employee_name, employee_birthday, employee_id_card," +
            " employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username" +
            " from employee where employee_id =?";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?, " +
            "employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id =?," +
            "division_id = ? where employee_id = ?";

    private EducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    private PositionRepository positionRepository = new PositionRepository();
    private DivisionRepository divisionRepository = new DivisionRepository();
    private UserRepository userRepository = new UserRepository();

    public EmployeeRepository() {
    }

    public void addEmployee(Employee employee) {
        try (Connection connection = MySQLConnection.getConnection();) {
            if (!employee.getEmployeeId().equals("")) {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
                preparedStatement.setString(1, employee.getEmployeeId());
                preparedStatement.setString(2, employee.getEmployeeName());
                preparedStatement.setString(3, employee.getEmployeeBirthDay());
                preparedStatement.setString(4, employee.getEmployeeIdCard());
                preparedStatement.setString(5, employee.getEmployeeSalary());
                preparedStatement.setString(6, employee.getEmployeePhone());
                preparedStatement.setString(7, employee.getEmployeeEmail());
                preparedStatement.setString(8, employee.getEmployeeAddress());
                preparedStatement.setString(9, employee.getPositionId().getPositionId());
                preparedStatement.setString(10, employee.getEducationDegreeId().getEducationDegreeId());
                preparedStatement.setString(11, employee.getDivisionId().getDivisionId());
                preparedStatement.setString(12, employee.getUserName().getUserName());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL_2);
                preparedStatement.setString(1, employee.getEmployeeName());
                preparedStatement.setString(2, employee.getEmployeeBirthDay());
                preparedStatement.setString(3, employee.getEmployeeIdCard());
                preparedStatement.setString(4, employee.getEmployeeSalary());
                preparedStatement.setString(5, employee.getEmployeePhone());
                preparedStatement.setString(6, employee.getEmployeeEmail());
                preparedStatement.setString(7, employee.getEmployeeAddress());
                preparedStatement.setString(8, employee.getPositionId().getPositionId());
                preparedStatement.setString(9, employee.getEducationDegreeId().getEducationDegreeId());
                preparedStatement.setString(10, employee.getDivisionId().getDivisionId());
                preparedStatement.setString(11, employee.getUserName().getUserName());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Employee selectEmployee(String id) {
        Employee employee = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String employeeName = rs.getString("employee_name");
                String employeeBirthDay = rs.getString("employee_birthday");
                String employeeIdCard = rs.getString("employee_id_card");
                String employeeSalary = rs.getString("employee_salary");
                String employeePhone = rs.getString("employee_phone");
                String employeeMail = rs.getString("employee_email");
                String employeeAddress = rs.getString("employee_address");
                Position positionId = positionRepository.selectPositionById(rs.getString("position_id"));
                EducationDegree educationDegreeId = educationDegreeRepository.selectEducationDegreeById(rs.getString("education_degree_id"));
                Division divisionId = divisionRepository.selectDivisionById(rs.getString("division_id"));
                User userName = userRepository.selectUserByName(rs.getString("username"));

                employee = new Employee(id,employeeName,employeeBirthDay,employeeIdCard,employeeSalary,employeePhone,
                        employeeMail,employeeAddress, positionId,educationDegreeId,divisionId,userName);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    public List<Employee> selectAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String employeeId = rs.getString("employee_id");
                String employeeName = rs.getString("employee_name");
                String employeeBirthDay = rs.getString("employee_birthday");
                String employeeIdCard = rs.getString("employee_id_card");
                String employeeSalary = rs.getString("employee_salary");
                String employeePhone = rs.getString("employee_phone");
                String employeeMail = rs.getString("employee_email");
                String employeeAddress = rs.getString("employee_address");
                Position positionId = positionRepository.selectPositionById(rs.getString("position_id"));
                EducationDegree educationDegreeId = educationDegreeRepository.selectEducationDegreeById(rs.getString("education_degree_id"));
                Division divisionId = divisionRepository.selectDivisionById(rs.getString("division_id"));
                User userName = userRepository.selectUserByName(rs.getString("username"));
                employees.add(new Employee(employeeId,employeeName,employeeBirthDay,employeeIdCard,employeeSalary,employeePhone,employeeMail,
                        employeeAddress,positionId,educationDegreeId,divisionId,userName));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    public List<Employee> selectEmployeeByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        String query = "{CALL search_employee(?)}";
        try (
                Connection connection = MySQLConnection.getConnection();
                CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1,name);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                String employeeId = rs.getString("employee_id");
                String employeeName = rs.getString("employee_name");
                String employeeBirthDay = rs.getString("employee_birthday");
                String employeeIdCard = rs.getString("employee_id_card");
                String employeeSalary = rs.getString("employee_salary");
                String employeePhone = rs.getString("employee_phone");
                String employeeMail = rs.getString("employee_email");
                String employeeAddress = rs.getString("employee_address");
                Position positionId = positionRepository.selectPositionById(rs.getString("position_id"));
                EducationDegree educationDegreeId = educationDegreeRepository.selectEducationDegreeById(rs.getString("education_degree_id"));
                Division divisionId = divisionRepository.selectDivisionById(rs.getString("division_id"));
                User userName = userRepository.selectUserByName(rs.getString("username"));
                employeeList.add(new Employee(employeeId,employeeName,employeeBirthDay,employeeIdCard,employeeSalary,employeePhone,employeeMail,
                        employeeAddress,positionId,educationDegreeId,divisionId,userName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public boolean deleteEmployee(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
            statement.setString(1, employee.getEmployeeName());
            statement.setString(2, employee.getEmployeeBirthDay());
            statement.setString(3, employee.getEmployeeIdCard());
            statement.setString(4, employee.getEmployeeSalary());
            statement.setString(5, employee.getEmployeePhone());
            statement.setString(6, employee.getEmployeeEmail());
            statement.setString(7, employee.getEmployeeAddress());
            statement.setString(8, employee.getPositionId().getPositionId());
            statement.setString(9, employee.getEducationDegreeId().getEducationDegreeId());
            statement.setString(10, employee.getDivisionId().getDivisionId());
//            statement.setString(11, employee.getUserName().getUserName());
            statement.setString(11, employee.getEmployeeId());
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
