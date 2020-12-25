package controller;

import models.Employee;
import models.RentType;
import models.Service;
import models.ServiceType;
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
        Service service = serviceService.getServiceById(id);
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
        String serviceName = request.getParameter("name");
        int serviceArea = Integer.parseInt(request.getParameter("area"));
        double serviceTypeCost = Double.parseDouble(request.getParameter("cost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        RentType rentType = rentTypeService.selectRentTypeById(request.getParameter("rentType"));
        ServiceType serviceType = serviceTypeService.selectServiceTypeById(request.getParameter("serviceType"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("pool"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        Service service = new Service(id,serviceName,serviceArea,serviceTypeCost,serviceMaxPeople,rentType,serviceType,
                standardRoom,description,poolArea,floor);
        try {
            serviceService.addNewService(service);
            response.sendRedirect("/admin/services");
        } catch (IOException e) {
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
