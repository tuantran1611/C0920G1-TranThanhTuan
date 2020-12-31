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
    <style>
        <%@ include file="/WEB-INF/libs/bootstrap/css/bootstrap.min.css" %>
    </style>
    <style>
        <%@ include file="/WEB-INF/libs/bootstrap/datatables/css/dataTables.bootstrap4.min.css" %>
    </style>
    <style>
        body {
            background-image: url("/admin/details-1-background.jpg");
            background-size: cover;
        }

        td {
            color: white;
        }

        #tableCustomer_info {
            color: white;
        }

    </style>
</head>
<body onload="myFunction('${message}')">

<div class="container" style="text-align: center">
    <h1>Benh An Management</h1>
</div>
<div class="container">
    <div style="float: left; margin-left: 10px">
        <a class="btn btn-primary" href="/admin">Back To Home</a><br/>
    </div>
    <table id="tableCustomer" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Ma benh an</th>
            <th>Ma benh nhan</th>
            <th>Ten benh nhan</th>
            <th>Ngay nhap vien</th>
            <th>Ngay ra vien</th>
            <th>Ly do nhap vien</th>
            <th>Tac vu</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="benhAn" items="${benhAns}">
            <tr>
                <td><c:out value="${benhAn.getIdBenhAn()}"/></td>
                <td><c:out value="${benhAn.getIdbenhNhan().getIdBenhNhan()}"/></td>
                <td><c:out value="${benhAn.getTenBenhNhan().getTenBenhNhan()}"/></td>
                <td><c:out value="${benhAn.getNgayNhapVien()}"/></td>
                <td><c:out value="${benhAn.getNgayRaVien()}"/></td>
                <td><c:out value="${benhAn.getLyDoNhapVien()}"/></td>
                <td style="text-align: center">
                    <a style="color: white" class="btn btn-warning"
                       href="/benhans?action=edit&id=${benhAn.getIdBenhAn()}">Edit</a>
                    <a style="color: white" class="btn btn-danger"
                       href="#" onclick="benhAnSetId('${benhAn.getIdBenhAn()}')"
                       data-toggle="modal" data-target="#deleteModal">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteEmployee" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteEmployee">Xoa benh an?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="modelId" size="50" disabled style="border: none;background: white">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger" onclick="submitDelete()">Delete</button>
            </div>
        </div>
    </div>
</div>

<form action="/benhans" id="delCustomer">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" id="idCustomer">
</form>

<script>
    <%@ include file="/WEB-INF/libs/bootstrap/jquery/jquery-3.5.1.min.js" %>
</script>
<script>
    <%@ include file="/WEB-INF/libs/bootstrap/js/popper.min.js" %>
</script>
<script>
    <%@ include file="/WEB-INF/libs/bootstrap/datatables/js/jquery.dataTables.min.js" %>
</script>
<script>
    <%@ include file="/WEB-INF/libs/bootstrap/datatables/js/dataTables.bootstrap4.min.js" %>
</script>
<script>
    <%@ include file="/WEB-INF/libs/bootstrap/js/bootstrap.min.js" %>
</script>
<script>
    <%@ include file="/WEB-INF/libs/bootstrap/js/bootstrap.bundle.js" %>
</script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip', // hidden ô search
            "lengthChange": false, //show entries
            "pageLength": 5 //Số row ở mỗi trang
        })
    })
</script>
<script type="text/javascript">
    function myFunction(message) {
        if(message) {
            $('#addNew').modal('show');
        }
    }
</script>
<script>
    function submitDelete() {
        document.getElementById("delCustomer").submit();
    }

    function benhAnSetId(id) {
        document.getElementById("idCustomer").value = id;
        document.getElementById("modelId").value = "Ban co muon xoa benh an nay: " + id;
    }
</script>
</body>
</html>