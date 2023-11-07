<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 02/11/2023
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SinhVien</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<p>Danh sach sinh vien</p>
<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Ho Ten</td>
        <td>Dia Chi</td>
        <td>Gioi Tinh</td>
        <td>Lop</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="i" items="${listSinhVien}" var="sinhVien">
        <tr>
            <td>${i.index}</td>
            <td>${sinhVien.id}</td>
            <td>${sinhVien.ten}</td>
            <td>${sinhVien.diaChi}</td>
            <td>${sinhVien.gioiTinh}</td>
            <td>${sinhVien.lop}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
