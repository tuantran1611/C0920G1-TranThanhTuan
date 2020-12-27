<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/16/2020
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<p><a href="/products">Back to menu</a> </p>
<form action="/products?action=edit&id=${requestScope["product"].getId()}" method="post">
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Product Name</td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getProductName()}"></td>
            </tr>
            <tr>
                <td>Product Price</td>
                <td><input type="text" name="price" id="price" value="${requestScope["product"].getProductPrice()}"></td>
            </tr>
            <tr>
                <td>Product Description</td>
                <td><input type="text" name="description" id="description" value="${requestScope["product"].getProductDescription()}"></td>
            </tr>
            <tr>
                <td>Producer</td>
                <td><input type="text" name="producer" id="producer" value="${requestScope["product"].getProducer()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Edit Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
