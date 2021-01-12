<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 1/4/2021
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator Programming</title>
  </head>
  <body>
    <h1>Calculator</h1>
    <form action="/calculate" method="post">
      <input type="number" name="number1" required>
      <input type="number" name="number2" required><br/>
      <button type="submit" name="calculate" value="Addition">Addition(+)</button>
      <button type="submit" name="calculate" value="Subtraction">Subtraction(-)</button>
      <button type="submit" name="calculate" value="Multiplication">Multiplication(x)</button>
      <button type="submit" name="calculate" value="Division">Division(/)</button>
    </form>
    <h3>${result}</h3>
  </body>
</html>
