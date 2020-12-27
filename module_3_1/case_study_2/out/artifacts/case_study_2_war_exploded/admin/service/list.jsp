<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/23/2020
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service Management Application</title>
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

        #tableService_info {
            color: white;
        }
    </style>
</head>
<body onload="myFunction('${message}')">
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
                        Customer Service
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
                    <a style="color: white" class="nav-link dropdown-toggle" href="/admin/contracts" id="navbarDropdown"
                       role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Contract
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/admin/contractDetails">Contract Detail</a>
                        <a class="dropdown-item" href="/admin/contracts">Attach Service</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/admin/contracts">Contract</a>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="/admin/services">
                <input type="hidden" name="action" value="search"/>
                <input name="searchWord" style="width: 300px" class="form-control mr-sm-2" type="text"
                       placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
<div class="container" style="text-align: center">
    <h1>Service Management</h1>
</div>
<div class="container">
    <!-- Button trigger modal -->
    <div style="float: left">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addNew">
            Add New Service
        </button>

        <!-- Modal -->
        <form action="/admin/services?action=create" method="post">
            <div class="modal fade" id="addNew" tabindex="-1" role="dialog" aria-labelledby="addNewSer"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="addNewSer">Add New Service</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <table>
                                <tr>
                                    <th>Service Id:</th>
                                    <td><input type="text" name="id" id="id" size="45" value="${service.getServiceId()}"/>
                                        <p>
                                            <c:if test='${message1!= null}'>
                                                <span style="color: red" class="message">${message1}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Service Name:</th>
                                    <td><input type="text" name="name" id="name" size="45" value="${service.getServiceName()}"/>
                                        <c:if test='${message9!= null}'>
                                            <span style="color: red" class="message">${message9}</span>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Service Area:</th>
                                    <td><input type="text" name="area" style="width: 100%" id="area" size="45" value="${service.getServiceArea()}"/>
                                        <p>
                                            <c:if test='${message2!= null}'>
                                                <span style="color: red" class="message">${message2}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Service Type Cost:</th>
                                    <td><input type="text" name="cost" style="width: 100%" id="cost" size="45" value="${service.getServiceTypeCost()}"/>
                                        <p>
                                            <c:if test='${message3!= null}'>
                                                <span style="color: red" class="message">${message3}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>

                                <tr>
                                    <th>Service Max People:</th>
                                    <td><input type="text" name="maxPeople" id="maxPeople" style="width: 100%" size="45" value="${service.getServiceMaxPeople()}"/>
                                        <p>
                                            <c:if test='${message4!= null}'>
                                                <span style="color: red" class="message">${message4}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>

                                <tr>
                                    <th>Rent Type Id:</th>
                                    <td>
                                        <select name="rentType" id="rentType" class="form-control">
                                            <option selected hidden value="${service.getRentType().getRentTypeId()}">${service.getRentType().getRentTypeName()}</option>
                                            <option value="1">Nam</option>
                                            <option value="2">Thang</option>
                                            <option value="3">Ngay</option>
                                            <option value="4">Gio</option>
                                        </select>
                                        <p>
                                            <c:if test='${message5!= null}'>
                                                <span style="color: red" class="message">${message5}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>

                                <tr>
                                    <th>Service Type ID:</th>
                                    <td>
                                        <select name="serviceType" id="serviceType" class="form-control">
                                            <option selected hidden value="${service.getServiceType().getServiceTypeId()}">${service.getServiceType().getServiceTypeName()}</option>
                                            <option value="1">Villa</option>
                                            <option value="2">House</option>
                                            <option value="3">Room</option>
                                        </select>
                                        <p>
                                            <c:if test='${message6!= null}'>
                                                <span style="color: red" class="message">${message6}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>

                                <tr>
                                    <th>Standard Room:</th>
                                    <td><input type="text" name="standardRoom" id="standardRoom" size="45" value="${service.getStandardRoom()}"/></td>
                                </tr>

                                <tr>
                                    <th>Description:</th>
                                    <td><input type="text" name="description" id="description" size="45" value="${service.getDescriptionConvenience()}"/></td>
                                </tr>

                                <tr>
                                    <th>Pool Area:</th>
                                    <td><input type="text" name="pool" id="pool" style="width: 100%" size="45" value="${service.getPoolArea()}"/>
                                        <p>
                                            <c:if test='${message7!= null}'>
                                                <span style="color: red" class="message">${message7}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Number of Floor:</th>
                                    <td><input type="text" name="floor" id="floor" style="width: 100%" size="45" value="${service.getNumberFloor()}"/>
                                        <p>
                                            <c:if test='${message8!= null}'>
                                                <span style="color: red" class="message">${message8}</span>
                                            </c:if>
                                        </p></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" id="submit_id">ADD</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div style="float: left; margin-left: 10px">
        <a class="btn btn-primary" href="/admin">Back To Home</a><br/>
    </div>
    <table id="tableService" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Service Id</th>
            <th>Service Name</th>
            <th>Service Area</th>
            <th>Rent Type</th>
            <th>Service Type</th>
            <th>Room Standard</th>
            <th>Pool Area</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${services}">
            <tr>
                <td><c:out value="${service.getServiceId()}"/></td>
                <td><a style="color: white" href="/admin/services?action=view&id=${service.getServiceId()}"><c:out
                        value="${service.getServiceName()}"/></a></td>
                <td><c:out value="${service.getServiceArea()}"/></td>
                <td><c:out value="${service.getRentType().getRentTypeName()}"/></td>
                <td><c:out value="${service.getServiceType().getServiceTypeName()}"/></td>
                <td><c:out value="${service.getStandardRoom()}"/></td>
                <td><c:out value="${service.getPoolArea()}"/></td>
                <td style="text-align: center">
                    <a style="color: white" class="btn btn-warning"
                       href="/admin/services?action=edit&id=${service.getServiceId()}">Edit</a>
                    <a style="color: white" class="btn btn-danger"
                       href="/admin/services?action=delete&id=${service.getServiceId()}">Delete</a>
                </td>
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
        $('#tableService').dataTable({
            "dom": 'lrtip', // hidden ô search
            "lengthChange": false, //show entries
            "pageLength": 5 //Số row ở mỗi trang
        })
    })
</script>
<script type="text/javascript">
    function myFunction(message) {
        if (message) {
            $('#addNew').modal('show');
        }
    }
</script>
</body>
</html>