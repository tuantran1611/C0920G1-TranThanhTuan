package controller;

import models.Contract;
import models.Customer;
import models.Employee;
import models.Service;
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

@WebServlet(name = "ContractServlet", urlPatterns = "/admin/contracts")
public class ContractServlet extends HttpServlet {

    private ContractService contractService;
    private ContractDetailService contractDetailService;
    private AttachServiceService attachServiceService;
    private EmployeeService employeeService;
    private CustomerService customerService;
    private ServiceService serviceService;

    public void init(){
        contractService = new ContractServiceImpl();
        contractDetailService = new ContractDetailServiceImpl();
        attachServiceService = new AttachServiceServiceImpl();
        employeeService = new EmployeeServiceImpl();
        customerService = new CustomerServiceImpl();
        serviceService = new ServiceServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "create":
                createContract(request,response);
                break;
        }
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        try {
            contractService.deleteContract(id);
            response.sendRedirect("/admin/contracts");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String startDate = request.getParameter("start");
        String endDate = request.getParameter("end");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("total"));
        Employee employee = employeeService.selectEmployee(request.getParameter("employee"));
        Customer customer = customerService.selectCustomer(request.getParameter("customer"));
        Service service = serviceService.getServiceById(request.getParameter("service"));
        Contract contract = new Contract(id, startDate, endDate, deposit, totalMoney, employee, customer, service);
        try {
            contractService.addContract(contract);
            response.sendRedirect("/admin/contracts");
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
            case "create":
                break;
            case "delete":
                deleteContract(request,response);
                break;
            default:
                listContract(request,response);
                break;
        }
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractService.selectAllContract();
        request.setAttribute("contracts", contractList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contract/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
