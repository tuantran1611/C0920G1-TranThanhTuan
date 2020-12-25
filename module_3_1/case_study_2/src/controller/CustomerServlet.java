package controller;

import models.Customer;
import models.CustomerType;
import models.CustomerUseService;
import services.CustomerServiceImpl;
import services.CustomerTypeServiceImpl;
import services.CustomerUseServiceServiceImpl;
import services.impl.CustomerService;
import services.impl.CustomerTypeService;
import services.impl.CustomerUseServiceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/admin/customers")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;
    private CustomerTypeService customerTypeService;
    private CustomerUseServiceService customerUseServiceService;

    public void init() {
        customerService = new CustomerServiceImpl();
        customerTypeService = new CustomerTypeServiceImpl();
        customerUseServiceService = new CustomerUseServiceServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showFormEdit(request, response);
                break;
            case "view":
                displayCustomer(request, response);
                break;
            case "search":
                searchCustomerByName(request,response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "useService":
                listCustomerUseService(request,response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) {
        String searchWord = request.getParameter("searchWord");
        List<Customer> customers = customerService.selectCustomerByName(searchWord);
        System.out.println(customers);
        request.setAttribute("customers" , customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        try {
            customerService.deleteCustomer(id);
            response.sendRedirect("/admin/customers");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {

        CustomerType customerTypeId = customerTypeService.getCusTypeById(request.getParameter("type"));
        String customerName = request.getParameter("name");
        String customerBirthDay = request.getParameter("birthday");
        boolean customerGender = Boolean.parseBoolean(request.getParameter("gender"));
        String customerIdCard = request.getParameter("idcard");
        String customerPhone = request.getParameter("phone");
        String customerEmail = request.getParameter("email");
        String customerAddress = request.getParameter("address");

        Customer customer = new Customer(customerTypeId, customerName, customerBirthDay, customerGender, customerIdCard,
                customerPhone, customerEmail, customerAddress);

        try {
            customerService.addCustomer(customer);
            response.sendRedirect("/admin/customers");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        CustomerType customerTypeId = customerTypeService.getCusTypeById(request.getParameter("type"));
        String customerName = request.getParameter("name");
        String customerBirthDay = request.getParameter("birthday");
        boolean customerGender = Boolean.parseBoolean(request.getParameter("gender"));
        String customerIdCard = request.getParameter("idcard");
        String customerPhone = request.getParameter("phone");
        String customerEmail = request.getParameter("email");
        String customerAddress = request.getParameter("address");
        try {
            customerService.updateCustomer(new Customer(id, customerTypeId, customerName, customerBirthDay,
                    customerGender, customerIdCard, customerPhone, customerEmail, customerAddress));
            response.sendRedirect("/admin/customers");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerService.selectCustomer(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/view.jsp");
        request.setAttribute("customer", customer);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerService.selectCustomer(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", customer);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerService.selectAllCustomer();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomerUseService(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerUseService> customerUseServiceList = customerUseServiceService.getAllCustomerUseService();
        request.setAttribute("customers", customerUseServiceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list1.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}