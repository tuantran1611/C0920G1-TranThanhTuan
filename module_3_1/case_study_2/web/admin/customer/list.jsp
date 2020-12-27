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
    <title>Customer Management Application</title>
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
    <h1>Customer Management</h1>
</div>
<div class="container">
    <!-- Button trigger modal -->
    <div style="float: left">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addNew">
            Add New Customer
        </button>

        <!-- Modal -->
        <form action="/admin/customers?action=create" method="post">
            <div class="modal fade" id="addNew" tabindex="-1" role="dialog" aria-labelledby="addNewCus"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        <!-- Header-->
                        <div class="modal-header">
                            <h5 class="modal-title" id="addNewCus">Add New Customer</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <!--Body -->
                        <div class="modal-body">
                            <table>
                                <tr>
                                    <th>Customer Id:</th>
                                    <td><input type="text" name="id" id="id" size="45" value="${customer.getCustomerId()}"/>
                                        <p>
                                            <c:if test='${message2!= null}'>
                                                <span style="color: red" class="message">${message2}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Customer Type Id:</th>
                                    <td>
                                        <select name="type" class="form-control" id="type">
                                                <option selected hidden value="${customer.getCustomerTypeId().getCustomerTypeId()}">${customer.getCustomerTypeId().getCustomerTypeName()}</option>
                                                <option value="1">Diamond</option>
                                                <option value="2">Platinium</option>
                                                <option value="3">Gold</option>
                                                <option value="4">Silver</option>
                                                <option value="5">Member</option>
                                        </select>
                                        <p>
                                            <c:if test='${message7!= null}'>
                                                <span style="color: red" class="message">${message7}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Customer Name:</th>
                                    <td>
                                        <input type="text" name="name" id="name" size="45" value="${customer.getCustomerName()}"/>
                                        <p>
                                            <c:if test='${message1!= null}'>
                                                <span style="color: red" class="message">${message1}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Customer BirthDay:</th>
                                    <td><input type="text" name="birthday" id="birthday" size="45" value="${customer.getCustomerBirthDay()}"/></td>
                                </tr>
                                <tr>
                                    <th>Customer Gender:</th>
                                    <td>
                                        <select name="gender" class="form-control" id="gender">
                                            <option value="true" ${customer.getCustomerGender() == 'true' ? 'selected':''}>Nam</option>
                                            <option value="false" ${customer.getCustomerGender() == 'false' ? 'selected':''}>Nữ</option>
                                        </select>
                                    </td>
                                </tr>

                                <tr>
                                    <th>Customer Id Card:</th>
                                    <td><input type="text" name="idcard" id="idcard" size="45" value="${customer.getCustomerIdCard()}"/>
                                        <p>
                                            <c:if test='${message3!= null}'>
                                                <span style="color: red" class="message">${message3}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>

                                <tr>
                                    <th>Customer Phone:</th>
                                    <td><input type="text" name="phone" id="phone" size="45" value="${customer.getCustomerPhone()}"/>
                                        <p>
                                            <c:if test='${message4!= null}'>
                                                <span style="color: red" class="message">${message4}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>

                                <tr>
                                    <th>Customer Email:</th>
                                    <td><input type="text" name="email" id="email" size="45" value="${customer.getCustomerEmail()}"/>
                                        <p>
                                            <c:if test='${message6!= null}'>
                                                <span style="color: red" class="message">${message6}</span>
                                            </c:if>
                                        </p>
                                    </td>
                                </tr>

                                <tr>
                                    <th>Customer Address:</th>
                                    <td><input type="text" name="address" id="address" size="45" value="${customer.getCustomerAddress()}"/></td>
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
    <table id="tableCustomer" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Customer Name</th>
            <th>Customer Birthday</th>
            <th>Customer Id Card</th>
            <th>Customer Address</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><a style="color: white" href="/admin/customers?action=view&id=${customer.getCustomerId()}"><c:out
                        value="${customer.getCustomerName()}"/></a></td>
                <td><c:out value="${customer.getCustomerBirthDay()}"/></td>
                <td><c:out value="${customer.getCustomerIdCard()}"/></td>
                <td><c:out value="${customer.getCustomerAddress()}"/></td>
                <td style="text-align: center">
                    <a style="color: white" class="btn btn-warning"
                       href="/admin/customers?action=edit&id=${customer.getCustomerId()}">Edit</a>
                    <a style="color: white" class="btn btn-danger"
                       href="#" onclick="customerSetId('${customer.getCustomerId()}','${customer.getCustomerName()}')"
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
                <h5 class="modal-title" id="deleteEmployee">Delete Customer?</h5>
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

<form action="/admin/customers" id="delCustomer">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" id="idCustomer">
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
        $('#tableCustomer').dataTable({
            "dom": 'lrtip', // hidden ô search
            "lengthChange": false, //show entries
            "pageLength": 5 //Số row ở mỗi trang
        })
    })
</script>
<script type="text/javascript">
    function myFunction(message) {
        if(message) {
            $('#addNew').modal('show');
        }
    }
</script>
<script>
    function submitDelete() {
        document.getElementById("delCustomer").submit();
    }

    function customerSetId(id, name) {
        document.getElementById("idCustomer").value = id;
        document.getElementById("modelId").value = "Do you want delete this customer: " + name;
    }
</script>
</body>
</html>