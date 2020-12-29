package controller;

import common.Validate;
import models.*;
import services.*;
import services.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/admin/employees")
public class EmployeeServlet extends HttpServlet {

    EmployeeService employeeService;
    PositionService positionService;
    EducationDegreeService educationDegreeService;
    DivisionService divisionService;
    UserService userService;


    public void init(){
        employeeService = new EmployeeServiceImpl();
        positionService = new PositionServiceImpl();
        educationDegreeService = new EducationDegreeServiceImpl();
        divisionService = new DivisionServiceImpl();
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "edit":
                showFormEdit(request,response);
                break;
            case "view":
                displayEmployee(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            case "search":
                searchEmployee(request,response);
            default:
                listEmployee(request,response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String searchWord = request.getParameter("searchWord");
        List<Employee> employees = employeeService.selectEmployeeByName(searchWord);
        request.setAttribute("employees",employees);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        try {
            if (!employeeService.deleteEmployee(id)){
                List<Employee> employees = employeeService.selectAllEmployee();
                request.setAttribute("employees", employees);
                RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
                dispatcher.forward(request,response);
            } else {
                response.sendRedirect("/admin/customers");
            }
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void displayEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = employeeService.selectEmployee1(id);
        request.setAttribute("employee", employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/view.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String employeeId = request.getParameter("id");
        String message1 = Validate.validateEmployeeId(employeeId);
        String employeeName = request.getParameter("name");
        String message2 = Validate.validateCustomerName(employeeName);
        String birthDay = request.getParameter("birthday");
        String idCard = request.getParameter("idcard");
        String message3 = Validate.validateCustomerIdCard(idCard);
        String salary = request.getParameter("salary");
        String message4 = Validate.validateServiceTypeCost(salary);
        String phone = request.getParameter("phone");
        String message5 = Validate.validateCustomerPhone(phone);
        String email = request.getParameter("email");
        String message6 = Validate.validateCustomerEmail(email);
        String address = request.getParameter("address");
        Position position = positionService.selectPositionById(request.getParameter("position"));
        String message7 = Validate.validatePosition(position);
        EducationDegree educationDegree = educationDegreeService.selectEducationDegreeById(request.getParameter("degree"));
        String message8 = Validate.validateDegree(educationDegree);
        Division division = divisionService.selectDivisionById(request.getParameter("division"));
        String message9 = Validate.validateDivision(division);
        userService.addUser(request.getParameter("userName"));
        String message10 = Validate.validateUserName(request.getParameter("userName"));
        User user = userService.selectUserByName(request.getParameter("userName"));

        Employee  employee = new Employee(employeeId,employeeName,birthDay,idCard,salary,phone,email,address,position,
                educationDegree,division,user);
        userService.deleteUser(request.getParameter("userName"));
        try {
            if (message1 == null && message2 == null && message3 == null && message4 == null&& message5 == null && message6 == null && message7 == null
            && message8 == null && message9 == null && message10 == null) {
                userService.addUser(request.getParameter("userName"));
                employeeService.addEmployee(employee);
                employee = null;
            } else {
                String message = "Not OK";
                request.setAttribute("message", message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Employee> employees = employeeService.selectAllEmployee();
        request.setAttribute("employees",employees);
        request.setAttribute("employee",employee);
        request.setAttribute("message1", message1);
        request.setAttribute("message2", message2);
        request.setAttribute("message3", message3);
        request.setAttribute("message4", message4);
        request.setAttribute("message5", message5);
        request.setAttribute("message6", message6);
        request.setAttribute("message7", message7);
        request.setAttribute("message8", message8);
        request.setAttribute("message9", message9);
        request.setAttribute("message10", message10);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        String employeeOldId = request.getParameter("oldId");
        String employeeId = request.getParameter("id");
        String message1 = Validate.validateEmployeeId(employeeId);
        String employeeName = request.getParameter("name");
        String message2 = Validate.validateCustomerName(employeeName);
        String birthDay = request.getParameter("birthday");
        String idCard = request.getParameter("idcard");
        String message3 = Validate.validateCustomerIdCard(idCard);
        String salary = request.getParameter("salary");
        String message4 = Validate.validateServiceTypeCost(salary);
        String phone = request.getParameter("phone");
        String message5 = Validate.validateCustomerPhone(phone);
        String email = request.getParameter("email");
        String message6 = Validate.validateCustomerEmail(email);
        String address = request.getParameter("address");
        Position position = positionService.selectPositionById(request.getParameter("position"));
        String message7 = Validate.validatePosition(position);
        EducationDegree educationDegree = educationDegreeService.selectEducationDegreeById(request.getParameter("degree"));
        String message8 = Validate.validateDegree(educationDegree);
        Division division = divisionService.selectDivisionById(request.getParameter("division"));
        String message9 = Validate.validateDivision(division);
        User user = userService.selectUserByName(request.getParameter("userName"));
        Employee employee;
        try {
            if (message1 == null && message2 == null && message3 == null && message4 == null&& message5 == null && message6 == null && message7 == null
                    && message8 == null && message9 == null) {
                if (!employeeOldId.equals(employeeId)) {
                    employee = new Employee(employeeId,employeeName.trim(),birthDay,idCard,salary,phone,email,address,position,educationDegree,division,user);
                    employeeService.addEmployee(employee);
                    employeeService.deleteEmployee(employeeOldId);
                } else {
                    employee = new Employee(employeeOldId,employeeName.trim(),birthDay,idCard,salary,phone,email,address,position,educationDegree,division,user);
                    employeeService.updateEmployee(employee);
                }
                response.sendRedirect("/admin/employees");
            } else {
                employee = new Employee(employeeId,employeeName.trim(),birthDay,idCard,salary,phone,email,address,position,educationDegree,division,user);
                request.setAttribute("employee",employee);
                request.setAttribute("message1", message1);
                request.setAttribute("message2", message2);
                request.setAttribute("message3", message3);
                request.setAttribute("message4", message4);
                request.setAttribute("message5", message5);
                request.setAttribute("message6", message6);
                request.setAttribute("message7", message7);
                request.setAttribute("message8", message8);
                request.setAttribute("message9", message9);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/edit.jsp");
                try {
                    requestDispatcher.forward(request,response);
                } catch (IOException | ServletException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = employeeService.selectEmployee(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("employee", employee);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employees",employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}