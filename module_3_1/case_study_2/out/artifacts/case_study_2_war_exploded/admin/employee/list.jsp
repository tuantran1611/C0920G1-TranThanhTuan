<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/24/2020
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
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

        #tableEmployee_info {
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
            <form class="form-inline my-2 my-lg-0" action="/admin/employees">
                <input type="hidden" name="action" value="search"/>
                <input name="searchWord" style="width: 300px" class="form-control mr-sm-2" type="text"
                       placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
<div class="container" style="text-align: center">
    <h1>Employee Management</h1>
</div>
<div class="container">
    <!-- Button trigger modal -->
    <div style="float: left">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addNew">
            Add New Employee
        </button>

        <!-- Modal -->
        <form action="/admin/employees?action=create" method="post">
            <div class="modal fade" id="addNew" tabindex="-1" role="dialog" aria-labelledby="addNewEmployee"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="addNewEmployee">Add New Employee</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <table>
                                <tr>
                                    <th>Employee Name:</th>
                                    <td><input type="text" name="name" id="name" size="45"/></td>
                                </tr>
                                <tr>
                                    <th>Birth Day:</th>
                                    <td><input type="text" name="birthday" id="birthday" size="45"/></td>
                                </tr>
                                <tr>
                                    <th>Id Card:</th>
                                    <td><input type="text" name="idcard" id="idcard" size="45"/></td>
                                </tr>
                                <tr>
                                    <th>Salary</th>
                                    <td><input type="text" name="salary" id="salary" size="45"/></td>
                                </tr>

                                <tr>
                                    <th>Phone:</th>
                                    <td><input type="text" name="phone" id="phone" size="45"/></td>
                                </tr>

                                <tr>
                                    <th>Email:</th>
                                    <td><input type="text" name="email" id="email" size="45"/></td>
                                </tr>

                                <tr>
                                    <th>Address:</th>
                                    <td><input type="text" name="address" id="address" size="45"/></td>
                                </tr>

                                <tr>
                                    <th>Position Id:</th>
                                    <td><input type="text" name="position" id="position" size="45"/></td>
                                </tr>

                                <tr>
                                    <th>Degree Id:</th>
                                    <td><input type="text" name="degree" id="degree" size="45"/></td>
                                </tr>

                                <tr>
                                    <th>Division Id:</th>
                                    <td><input type="text" name="division" id="division" size="45"/></td>
                                </tr>

                                <tr>
                                    <th>User Name:</th>
                                    <td><input type="text" name="userName" id="userName" size="45"/></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <input class="btn btn-primary" type="submit" value="Add"/>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div style="float: left; margin-left: 10px">
        <a class="btn btn-primary" href="/admin">Back To Home</a><br/>
    </div>
    <table id="tableEmployee" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Employee Name</th>
            <th>Birthday</th>
            <th>Phone</th>
            <th>Id Card</th>
            <th>Position</th>
            <th>Education</th>
            <th>Division</th>
            <th>User Name</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td><a style="color: white" href="/admin/employees?action=view&id=${employee.getEmployeeId()}"><c:out
                        value="${employee.getEmployeeName()}"/></a></td>
                <td><c:out value="${employee.getEmployeeBirthDay()}"/></td>
                <td><c:out value="${employee.getEmployeePhone()}"/></td>
                <td><c:out value="${employee.getEmployeeIdCard()}"/></td>
                <td><c:out value="${employee.getPositionId().getPositionName()}"/></td>
                <td><c:out value="${employee.getEducationDegreeId().getEducationDegreeName()}"/></td>
                <td><c:out value="${employee.getDivisionId().getDivisionName()}"/></td>
                <td><c:out value="${employee.getUserName().getUserName()}"/></td>
                <td style="text-align: center">
                    <a style="color: white" class="btn btn-warning"
                       href="/admin/employees?action=edit&id=${employee.getEmployeeId()}">Edit</a>
                    <a style="color: white" class="btn btn-danger"
                       href="#" onclick="employeeSetId('${employee.getEmployeeId()}','${employee.getEmployeeName()}')"
                       data-toggle="modal" data-target="#deleteModal">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteEmployee" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteEmployee">Delete Employee?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="modelId" size="50" disabled style="border: none;background: white">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger" onclick="submitDelete()">Delete</button>
            </div>
        </div>
    </div>
</div>

<form action="/admin/employees" id="delEmployee">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" id="idEmployee">
</form>


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
        $('#tableEmployee').dataTable({
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
<script>
    function submitDelete() {
        document.getElementById("delEmployee").submit();
    }

    function employeeSetId(id, name) {
        document.getElementById("idEmployee").value = id;
        document.getElementById("modelId").value = "Do you want delete this employee: " + name;
    }
</script>
</body>
</html>
