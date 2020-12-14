<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/14/2020
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form method="post" action="/calculate">
    <label>Product Description: </label></br>
    <input type="text" name="description"></br>
    <label>List Price: </label></br>
    <input type="text" name="price"></br>
    <label>Discount Percent: </label></br>
    <input type="text" name="discount"></br></br>
    <button type="submit">Calculate Discount</button>
  </form>
  </body>
</html>
