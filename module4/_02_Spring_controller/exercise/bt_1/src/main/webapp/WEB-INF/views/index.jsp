<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 1/4/2021
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich Condiments</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="/save" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">
    <label>Lettuce</label>
    <input type="checkbox" name="condiment" value="Tomato">
    <label>Tomato</label>
    <input type="checkbox" name="condiment" value="Mustard">
    <label>Mustard</label>
    <input type="checkbox" name="condiment" value="Sprouts">
    <label>Sprouts</label>
    <br/><input type="submit" value="Save">
  </form>
  ${sandwich}
  </body>
</html>
