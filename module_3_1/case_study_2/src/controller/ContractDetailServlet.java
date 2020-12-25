package controller;

import models.AttachService;
import models.Contract;
import models.ContractDetail;
import services.AttachServiceServiceImpl;
import services.ContractDetailServiceImpl;
import services.ContractServiceImpl;
import services.impl.AttachServiceService;
import services.impl.ContractDetailService;
import services.impl.ContractService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/admin/contractDetails")
public class ContractDetailServlet extends HttpServlet {

    ContractDetailService contractDetailService;
    ContractService contractService;
    AttachServiceService attachServiceService;

    public void init(){
        contractDetailService = new ContractDetailServiceImpl();
        contractService = new ContractServiceImpl();
        attachServiceService = new AttachServiceServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        if ("create".equals(action)){
            createContractDetail(request,response);
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Contract contract = contractService.selectContract(request.getParameter("contract"));
        AttachService attachService = attachServiceService.selectAttachServiceById(request.getParameter("attach"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(id,contract,attachService,quantity);
        contractDetailService.addNewContractDetail(contractDetail);
        try {
            response.sendRedirect("/admin/contractDetails");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        if ("delete".equals(action)){
            deleteContractDetail(request,response);
        } else {
            listContractDetail(request,response);
        }
    }

    private void deleteContractDetail(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        try {
            contractDetailService.deleteContractDetail(id);
            response.sendRedirect("/admin/contractDetails");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void listContractDetail(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> contractDetailList = contractDetailService.getAllContractDetail();
        request.setAttribute("contractDetails", contractDetailList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contractDetail/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
