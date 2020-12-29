package controller;

import common.Validate;
import models.Contract;
import models.Customer;
import models.CustomerType;
import models.CustomerUseService;
import services.ContractServiceImpl;
import services.CustomerServiceImpl;
import services.CustomerTypeServiceImpl;
import services.CustomerUseServiceServiceImpl;
import services.impl.ContractService;
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
    private ContractService contractService;

    public void init() {
        customerService = new CustomerServiceImpl();
        customerTypeService = new CustomerTypeServiceImpl();
        customerUseServiceService = new CustomerUseServiceServiceImpl();
        contractService = new ContractServiceImpl();
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
            if (!customerService.deleteCustomer(id)){
                List<Customer> customers = customerService.selectAllCustomer();
                request.setAttribute("customers", customers);
                RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
                dispatcher.forward(request,response);
            } else {
                response.sendRedirect("/admin/customers");
            }

        } catch (ServletException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customerId = request.getParameter("id");
        String message2 = Validate.validateCustomerId(customerId);
        CustomerType customerTypeId = customerTypeService.getCusTypeById(request.getParameter("type"));
        String message7 = Validate.validateCustomerType(customerTypeId);
        String customerName = request.getParameter("name");
        String message1 = Validate.validateCustomerName(customerName.trim());
        String customerBirthDay = request.getParameter("birthday");
        boolean customerGender = Boolean.parseBoolean(request.getParameter("gender"));
        String customerIdCard = request.getParameter("idcard");
        String message3 = Validate.validateCustomerIdCard(customerIdCard);
        String customerPhone = request.getParameter("phone");
        String message4 = Validate.validateCustomerPhone(customerPhone);
        String customerEmail = request.getParameter("email");
        String message6 = Validate.validateCustomerEmail(customerEmail);
        String customerAddress = request.getParameter("address");

        Customer customer = new Customer(customerId,customerTypeId, customerName.trim(), customerBirthDay, customerGender, customerIdCard,
                customerPhone, customerEmail, customerAddress);

        try {
            if (message1 == null && message2 == null && message3 == null && message4 == null && message6 == null && message7 == null) {
                customerService.addCustomer(customer);
                customer = null;
            } else {
                String message5 = "Not OK";
                request.setAttribute("message", message5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Customer> customers = customerService.selectAllCustomer();
        List<CustomerType> customerTypeList = customerTypeService.getAll();
        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("customers",customers);
        request.setAttribute("customer",customer);
        request.setAttribute("message1", message1);
        request.setAttribute("message2", message2);
        request.setAttribute("message3", message3);
        request.setAttribute("message4", message4);
        request.setAttribute("message6", message6);
        request.setAttribute("message7", message7);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customerId = request.getParameter("id");
        String message2 = Validate.validateCustomerId(customerId);
        CustomerType customerTypeId = customerTypeService.getCusTypeById(request.getParameter("type"));
        String message7 = Validate.validateCustomerType(customerTypeId);
        String customerName = request.getParameter("name");
        String message1 = Validate.validateCustomerName(customerName.trim());
        String customerBirthDay = request.getParameter("birthday");
        boolean customerGender = Boolean.parseBoolean(request.getParameter("gender"));
        String customerIdCard = request.getParameter("idcard");
        String message3 = Validate.validateCustomerIdCard(customerIdCard);
        String customerPhone = request.getParameter("phone");
        String message4 = Validate.validateCustomerPhone(customerPhone);
        String customerEmail = request.getParameter("email");
        String message6 = Validate.validateCustomerEmail(customerEmail);
        String customerAddress = request.getParameter("address");

        System.out.println(customerId);

        Customer customer = new Customer(customerId, customerTypeId, customerName.trim(), customerBirthDay, customerGender, customerIdCard,
                customerPhone, customerEmail, customerAddress);
        try {
            if (message1 == null && message2 == null && message3 == null && message4 == null && message6 == null && message7 == null) {
                customerService.updateCustomer(customer);
                response.sendRedirect("/admin/customers");
            } else {
                request.setAttribute("customer", customer);
                request.setAttribute("message1", message1);
                request.setAttribute("message2", message2);
                request.setAttribute("message3", message3);
                request.setAttribute("message4", message4);
                request.setAttribute("message6", message6);
                request.setAttribute("message7", message7);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
                try {
                    requestDispatcher.forward(request, response);
                } catch (IOException | ServletException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = (request.getParameter("id"));
        System.out.println(id);
        Customer customer = customerService.selectCustomer1(id.substring(3));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/view.jsp");
        request.setAttribute("customer", customer);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        String id = (request.getParameter("id"));
        Customer customer = customerService.selectCustomer(id.substring(3));
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