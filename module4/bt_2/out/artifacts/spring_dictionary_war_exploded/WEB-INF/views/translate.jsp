<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/31/2020
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basic Dictionary</title>
</head>
<body>
<form action="/eng-vn">
    <input type="text" name="eng" id="eng"/><br/>
    <input type="submit" value="Translate">
</form>
<p>${vn}</p>
</body>
</html>
