<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/22/2020
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
    <style><%@ include file="/WEB-INF/libs/bootstrap/css/bootstrap.min.css"%></style>
    <style><%@ include file="/WEB-INF/libs/bootstrap/datatables/css/dataTables.bootstrap4.min.css"%></style>
    <style>
        body {
            background-image: url("/admin/details-1-background.jpg");
            background-size: cover;
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
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
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
            <form class="form-inline my-2 my-lg-0">
                <input style="width: 300px" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
<center>
    <h1>Customer Management</h1>
    <h3>Form edit customer</h3>
</center>
<div align="center">
    <form action="/admin/customers?action=edit&id=${customer.getCustomerId()}" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>
            <tr>
                <th>Customer Type:</th>
                <td>
<%--                    <input type="text" name="type" size="45"--%>
<%--                           value="${customer.getCustomerTypeId().getCustomerTypeId()}"--%>
<%--                    />--%>
                    <select name="type" class="form-control" id="type">
                        <option selected hidden value="${customer.getCustomerTypeId().getCustomerTypeId()}">${customer.getCustomerTypeId().getCustomerTypeName()}</option>
                        <option value="1">Diamond</option>
                        <option value="2">Platinium</option>
                        <option value="3">Gold</option>
                        <option value="4">Silver</option>
                        <option value="5">Member</option>
                    </select>

                </td>
            </tr>

            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="${customer.getCustomerName()}"
                    />
                </td>
            </tr>

            <tr>
                <th>Customer BirthDay:</th>
                <td>
                    <input type="text" name="birthday" size="45"
                           value="${customer.getCustomerBirthDay()}"
                    />
                </td>
            </tr>

            <tr>
                <th>Customer Gender:</th>
                <td>
                    <select name="gender" class="form-control" id="gender">
                        <option hidden value="${customer.getCustomerGender()}">${customer.getCustomerGender()?'Nam':'Nữ'}</option>
                        <option value="true">Nam</option>
                        <option value="false">Nữ</option>
                    </select>

                </td>
            </tr>

            <tr>
                <th>Customer Id Card:</th>
                <td>
                    <input type="text" name="idcard" size="45"
                           value="${customer.getCustomerIdCard()}"
                    />
                </td>
            </tr>

            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="${customer.getCustomerPhone()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="${customer.getCustomerEmail()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="${customer.getCustomerAddress()}"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input class="btn btn-warning" type="submit" value="Save"/>
                    <a class="btn btn-danger" href="/admin/customers">Cancel</a>
                    <a class="btn btn-success" href="/admin/customers">Back</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<script><%@ include file="/WEB-INF/libs/bootstrap/jquery/jquery-3.5.1.min.js"%></script>
<script><%@ include file="/WEB-INF/libs/bootstrap/js/popper.min.js"%></script>
<script><%@ include file="/WEB-INF/libs/bootstrap/datatables/js/jquery.dataTables.min.js"%></script>
<script><%@ include file="/WEB-INF/libs/bootstrap/datatables/js/dataTables.bootstrap4.min.js"%></script>
<script><%@ include file="/WEB-INF/libs/bootstrap/js/bootstrap.min.js"%></script>
<script><%@ include file="/WEB-INF/libs/bootstrap/js/bootstrap.bundle.js"%></script>
</body>
</html>
