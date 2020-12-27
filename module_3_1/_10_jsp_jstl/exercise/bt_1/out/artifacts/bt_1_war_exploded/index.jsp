<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/15/2020
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
<table class="table">
    <tr>
        <th style="text-align: center" colspan="4">Danh sách khách hàng</th>
    </tr>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <tr>
        <td>Mai Văn Hoàn</td>
        <td>1983-08-20</td>
        <td>Hà Nội</td>
        <td><img src="anh1.jpg" style="width: 70px; height: 70px"></td>
    </tr>
    <tr>
        <td>Nguyễn Văn Nam</td>
        <td>1983-08-21</td>
        <td>Bắc Giang</td>
        <td><img src="anh2.jpg" style="width: 70px; height: 70px"></td>
    </tr>
    <tr>
        <td>Nguyễn Thái Hòa</td>
        <td>1983-08-22</td>
        <td>Nam Định</td>
        <td><img src="anh3.jpg" style="width: 70px; height: 70px"></td>
    </tr>
    <tr>
        <td>Trần Đăng Khoa</td>
        <td>1983-08-23</td>
        <td>Đà Nẵng</td>
        <td><img src="anh1.jpg" style="width: 70px; height: 70px"></td>
    </tr>
</table>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>
