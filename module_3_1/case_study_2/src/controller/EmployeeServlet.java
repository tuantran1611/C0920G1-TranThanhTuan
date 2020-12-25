package controller;

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

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String employeeName = request.getParameter("name");
        String birthDay = request.getParameter("birthday");
        String idCard = request.getParameter("idcard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Position position = positionService.selectPositionById(request.getParameter("position"));
        EducationDegree educationDegree = educationDegreeService.selectEducationDegreeById(request.getParameter("degree"));
        Division division = divisionService.selectDivisionById(request.getParameter("division"));
        User user = userService.selectUserByName(request.getParameter("userName"));
        try {
            employeeService.updateEmployee(new Employee(id,employeeName,birthDay,idCard,salary,phone,email,address,position,
                    educationDegree,division,user));
            response.sendRedirect("/admin/employees");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
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
            employeeService.deleteEmployee(id);
            response.sendRedirect("/admin/employees");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = employeeService.selectEmployee(id);
        request.setAttribute("employee", employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/view.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String employeeName = request.getParameter("name");
        String birthDay = request.getParameter("birthday");
        String idCard = request.getParameter("idcard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Position position = positionService.selectPositionById(request.getParameter("position"));
        EducationDegree educationDegree = educationDegreeService.selectEducationDegreeById(request.getParameter("degree"));
        Division division = divisionService.selectDivisionById(request.getParameter("division"));
        User user = userService.selectUserByName(request.getParameter("userName"));

        Employee  employee = new Employee(employeeName,birthDay,idCard,salary,phone,email,address,position,
                educationDegree,division,user);
         try {
            employeeService.addEmployee(employee);
            response.sendRedirect("/admin/employees");
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