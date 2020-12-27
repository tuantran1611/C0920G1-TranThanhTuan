<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/21/2020
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
        <table border="1" cellpadding="5">
            <caption>
                <h2>User Information</h2>
            </caption>
            <tr>
                <th>Id:</th>
                <td>
                    ${requestScope["user"].getId()}
                </td>
            </tr>
            <tr>
                <th>User Name:</th>
                <td>
                    ${requestScope["user"].getName()}
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    ${requestScope["user"].getEmail()}
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    ${requestScope["user"].getCountry()}
                </td>
            </tr>
        </table>
</div>
</body>
</html>
