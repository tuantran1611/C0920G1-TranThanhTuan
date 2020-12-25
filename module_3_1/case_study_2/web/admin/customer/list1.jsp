<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/21/2020
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Use Service Management Application</title>
    <style>
        <%@ include file="/WEB-INF/libs/bootstrap/css/bootstrap.min.css" %>
    </style>
    <style>
        <%@ include file="/WEB-INF/libs/bootstrap/datatables/css/dataTables.bootstrap4.min.css" %>
    </style>
    <style>
        body {
            background-image: url("/admin/details-1-background.jpg");
            background-size: cover;
        }

        td {
            color: white;
        }

        #tableCustomer_info {
            color: white;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <header class="container">
        <div style="float: left;margin-top: 10px">
            <a href="/admin" title="Furama Resort">
                <img src="/admin/furama.png" alt="Furama Resort" height="77px" width="77px">
            </a>
        </div>
        <div style="float: right">
            <a href="#">
                Đăng nhập/Đăng ký
            </a>
        </div>
    </header>
    <nav style="clear: both" class="navbar navbar-expand-lg navbar-light container">
        <a style="color: white" class="navbar-brand" href="/admin">HOME</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a style="color: white" class="nav-link" href="/admin/employees">Employee</a>
                </li>

                <li class="nav-item dropdown">
                    <a style="color: white" class="nav-link dropdown-toggle" href="/admin/customers" id="navbarDropdown2"
                       role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Customer Use Service
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                        <a class="dropdown-item" href="/admin/customers?action=useService">Customer Use Attach Service</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/admin/customers">Customer</a>
                    </div>
                </li>


                <li class="nav-item">
                    <a style="color: white" class="nav-link" href="/admin/services">Service</a>
                </li>

                <li class="nav-item dropdown">
                    <a style="color: white" class="nav-link dropdown-toggle" href="/admin/contracts" id="navbarDropdown1"
                       role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Contract
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                        <a class="dropdown-item" href="/admin/contractDetails">Contract Detail</a>
                        <a class="dropdown-item" href="/admin/contracts">Attach Service</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/admin/contracts">Contract</a>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="/admin/customers">
                <input type="hidden" name="action" value="search"/>
                <input name="searchWord" style="width: 300px" class="form-control mr-sm-2" type="text"
                       placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
<div class="container" style="text-align: center">
    <h1>Customer Use Service Management</h1>
</div>
<div class="container">
    <div style="float: left; margin-left: 10px">
        <a class="btn btn-primary" href="/admin">Back To Home</a><br/>
    </div>
    <table id="tableCustomer" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Customer Name</th>
            <th>Customer Address</th>
            <th>Contract End Date</th>
            <th>Service</th>
            <th>Contract Detail Id</th>
            <th>Attach Service</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><c:out value="${customer.getCustomerName()}"/></td>
                <td><c:out value="${customer.getCustomerAddress()}"/></td>
                <td><c:out value="${customer.getContract().getContractEndDate()}"/></td>
                <td><c:out value="${customer.getService().getServiceName()}"/></td>
                <td><c:out value="${customer.getContractDetail().getContractDetailId()}"/></td>
                <td><c:out value="${customer.getAttachService().getAttachServiceName()}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    <%@ include file="/WEB-INF/libs/bootstrap/jquery/jquery-3.5.1.min.js" %>
</script>
<script>
    <%@ include file="/WEB-INF/libs/bootstrap/js/popper.min.js" %>
</script>
<script>
    <%@ include file="/WEB-INF/libs/bootstrap/datatables/js/jquery.dataTables.min.js" %>
</script>
<script>
    <%@ include file="/WEB-INF/libs/bootstrap/datatables/js/dataTables.bootstrap4.min.js" %>
</script>
<script>
    <%@ include file="/WEB-INF/libs/bootstrap/js/bootstrap.min.js" %>
</script>
<script>
    <%@ include file="/WEB-INF/libs/bootstrap/js/bootstrap.bundle.js" %>
</script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip', // hidden ô search
            "lengthChange": false, //show entries
            "pageLength": 5 //Số row ở mỗi trang
        })
    })
</script>
</body>
</html>