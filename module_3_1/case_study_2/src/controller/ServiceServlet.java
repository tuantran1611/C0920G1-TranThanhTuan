package controller;

import common.Validate;
import models.*;
import services.RentTypeServiceImpl;
import services.ServiceServiceImpl;
import services.ServiceTypeServiceImpl;
import services.impl.RentTypeService;
import services.impl.ServiceService;
import services.impl.ServiceTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/admin/services")
public class ServiceServlet extends HttpServlet {
    private ServiceService serviceService;
    private RentTypeService rentTypeService;
    private ServiceTypeService serviceTypeService;

    public void init(){
        serviceService = new ServiceServiceImpl();
        rentTypeService = new RentTypeServiceImpl();
        serviceTypeService = new ServiceTypeServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        if ("create".equals(action)) {
            createService(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        if ("view".equals(action)) {
            displayService(request, response);
        } else if ("search".equals(action)) {
            searchService(request,response);
        } else {
            listService(request, response);
        }
    }

    private void searchService(HttpServletRequest request, HttpServletResponse response) {
        String searchWord = request.getParameter("searchWord");
        List<Service> services = serviceService.selectServiceByName(searchWord);
        request.setAttribute("services",services);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service service = serviceService.getServiceById(id.substring(3));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/view.jsp");
        request.setAttribute("service", service);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String message1 = Validate.validateServiceId(id);
        String serviceName = request.getParameter("name");
        String message9 = Validate.validateServiceName(serviceName);
        String serviceArea = request.getParameter("area");
        String message2 = Validate.validateServiceArea(serviceArea);
        String serviceTypeCost = request.getParameter("cost");
        String message3 = Validate.validateServiceTypeCost(serviceTypeCost);
        String serviceMaxPeople = request.getParameter("maxPeople");
        String message4 = Validate.validateServiceArea(serviceMaxPeople);
        RentType rentType = rentTypeService.selectRentTypeById(request.getParameter("rentType"));
        String message5 = Validate.validateRentType(rentType);
        ServiceType serviceType = serviceTypeService.selectServiceTypeById(request.getParameter("serviceType"));
        String message6 = Validate.validateServiceType(serviceType);
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        String poolArea = request.getParameter("pool");
        String message7 = Validate.validateServiceTypeCost(poolArea);
        String floor = request.getParameter("floor");
        String message8 = Validate.validateServiceArea(floor);
        Service service = new Service(id,serviceName,serviceArea,serviceTypeCost,
                serviceMaxPeople,rentType,serviceType
                ,standardRoom,description,poolArea,floor);

        if (message1 == null && message2 == null && message3 == null && message4 == null && message5 == null &&
                message6 == null && message7 == null && message8 == null && message9 == null) {
            serviceService.addNewService(service);
            service = null;
        } else {
            String message = "Not OK";
            request.setAttribute("message", message);
        }
        List<Service> services = serviceService.getAllService();
        request.setAttribute("services",services);
        request.setAttribute("service",service);
        request.setAttribute("message1", message1);
        request.setAttribute("message2", message2);
        request.setAttribute("message3", message3);
        request.setAttribute("message4", message4);
        request.setAttribute("message5", message5);
        request.setAttribute("message6", message6);
        request.setAttribute("message7", message7);
        request.setAttribute("message8", message8);
        request.setAttribute("message9", message9);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList;
        serviceList = serviceService.getAllService();
        request.setAttribute("services", serviceList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
