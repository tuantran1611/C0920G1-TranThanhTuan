<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 1/5/2021
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Box Setting</title>
</head>
<body>
<h1>Setting</h1>
<form:form action="submit" method="post" modelAttribute="mailbox">
    <table class="table">
        <tr>
            <td>Language:</td>
            <td>
                <form:select path="languages">
                <form:option value="NONE"> --SELECT-- </form:option>
                <form:options items="${languageList}"></form:options>
                </form:select>
            </td>
            </td>
        </tr>

        <tr>
            <td>Pages Size:</td>
            <td>
                <label>Show
                    <form:select path="pageSize">
                    <form:option value="0"> --SELECT-- </form:option>
                    <form:options items="${pageSizeList}"/>
                    </form:select> emails per page
                </label>
            </td>
        </tr>

        <tr>
            <td>Spam filers:</td>
            <td>
                <label>
                    <form:checkbox path="spamFilter" value="1" label="Enable spams filter"/>
                </label>
            </td>
        </tr>

        <tr>
            <td>Signature:</td>
            <td>
                <label>
                    <form:textarea path="signature" rows="5"/>
                </label>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update">
                <input type="reset" value="Cancel">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
