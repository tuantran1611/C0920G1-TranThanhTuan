<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 12/29/2020
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
    <style><%@ include file="/WEB-INF/libs/bootstrap/css/bootstrap.min.css"%></style>
    <style><%@ include file="/WEB-INF/libs/bootstrap/datatables/css/dataTables.bootstrap4.min.css"%></style>
    <style>
        body {
            background-image: url("/admin/details-1-background.jpg");
            background-size: cover;
        }
    </style>
</head>
<body>
<center>
    <h1>Benh An Management</h1>
    <h3>Form edit Benh An</h3>
</center>
<div align="center">
    <form action="/benhans?action=edit&id=${benhan.getIdBenhAn()}" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Benh An
                </h2>
            </caption>
            <tr>
                <th>Benh An Id:</th>
                <td>
                    <label>
                        <input readonly  type="text" name="idBenhAn" size="45"
                                value="${benhAn.getIdBenhAn()}"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Benh Nhan Id:</th>
                <td>
                    <label>
                        <input readonly  type="text" name="idBenhNhan" size="45"
                               value="${benhAn.getIdbenhNhan().getIdBenhNhan()}"
                        />
                    </label>
                </td>
            </tr>

            <tr>
                <th>Ten Benh Nhan:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="${benhAn.getIdbenhNhan().getTenBenhNhan()}"
                    />
                    <p>
                        <c:if test='${message1!= null}'>
                            <span style="color: red" class="message">${message1}</span>
                        </c:if>
                    </p>
                </td>
            </tr>

            <tr>
                <th>Ngay Nhap Vien:</th>
                <td>
                    <input type="date" style="width: 100%" name="ngayNhapVien" size="45"
                           value="<c:out value="${benhAn.getNgayNhapVien()}"/>"
                    />
                    <%--                    <p>--%>
                    <%--                        <c:if test='${message4!= null}'>--%>
                    <%--                            <span style="color: red" class="message">${message4}</span>--%>
                    <%--                        </c:if>--%>
                    <%--                    </p>--%>
                </td>
            </tr>

            <tr>
                <th>Ngay Ra Vien:</th>
                <td>
                    <input type="date" style="width: 100%" name="ngayNhapVien" size="45"
                           value="<c:out value="${benhAn.getNgayRaVien()}"/>"
                    />
                    <%--                    <p>--%>
                    <%--                        <c:if test='${message4!= null}'>--%>
                    <%--                            <span style="color: red" class="message">${message4}</span>--%>
                    <%--                        </c:if>--%>
                    <%--                    </p>--%>
                </td>
            </tr>

            <tr>
                <th>Ly Do Nhap Vien:</th>
                <td>
                    <input type="text" name="lyDo" size="45"
                           value="${benhAn.getLyDoNhapVien()}"
                    />
                    <p>
                        <c:if test='${message3!= null}'>
                            <span style="color: red" class="message">${message3}</span>
                        </c:if>
                    </p>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input class="btn btn-warning" type="submit" value="Save"/>
                    <a class="btn btn-danger" href="/benhans">Cancel</a>
                    <a class="btn btn-success" href="/benhans">Back</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<script><%@ include file="/WEB-INF/libs/bootstrap/jquery/jquery-3.5.1.min.js"%></script>
<script><%@ include file="/WEB-INF/libs/bootstrap/js/popper.min.js"%></script>
<script><%@ include file="/WEB-INF/libs/bootstrap/datatables/js/jquery.dataTables.min.js"%></script>
<script><%@ include file="/WEB-INF/libs/bootstrap/datatables/js/dataTables.bootstrap4.min.js"%></script>
<script><%@ include file="/WEB-INF/libs/bootstrap/js/bootstrap.min.js"%></script>
<script><%@ include file="/WEB-INF/libs/bootstrap/js/bootstrap.bundle.js"%></script>
</body>
</html>
