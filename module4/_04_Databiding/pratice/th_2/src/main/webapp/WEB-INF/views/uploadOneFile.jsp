<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 1/5/2021
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Upload Multi File</title>

</head>

<body>

<jsp:include page="_menu.jsp"/>

<h3>Upload Multiple File:</h3>

<!-- MyUploadForm -->

<form:form modelAttribute="myUploadForm" method="POST" action="/uploadOneFile" enctype="multipart/form-data">

    Description:

    <br>

    <form:input path="description" style="width:300px;"/>

    <br/><br/>

<%--    <form:label path="fileDatas">File to upload (1):</form:label> <form:input path="fileDatas" type="file"/><br/>--%>

<%--    <form:label path="fileDatas">File to upload (2):</form:label> <form:input path="fileDatas" type="file"/><br />--%>

<%--    <form:label path="fileDatas">File to upload (3):</form:label> <form:input path="fileDatas" type="file"/><br />--%>

<%--    <form:label path="fileDatas">File to upload (4):</form:label> <form:input path="fileDatas" type="file"/><br />--%>

<%--    <form:label path="fileDatas">File to upload (5):</form:label> <form:input path="fileDatas" type="file"/><br />--%>

    <input type="submit" value="Upload">

</form:form>

</body>

</html>