<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/16/2020
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display All Product</title>
</head>
<body>
    <h1>All Product</h1>
    <p>
        <a href="/products?action=create">Add new product</a>
    </p>
    <table border="1px">
        <tr>
            <th>Product Id</th>
            <th>Product Name</th>
            <th>Product Price</th>
            <th>Product Description</th>
            <th>Producer</th>
        </tr>
        <c:forEach items='${requestScope["products"]}' var="product">
            <tr>
                <td>${product.getId()}</td>
                <td><a href="/products?action=view&id=${product.getId()}">${product.getProductName()}</a></td>
                <td>${product.getProductPrice()}</td>
                <td>${product.getProductDescription()}</td>
                <td>${product.getProducer()}</td>
                <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
                <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
