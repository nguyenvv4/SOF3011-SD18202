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
<body class="container">
<form action="/sinh-vien/add" method="post">
    <div class="mb-3">
        <label class="form-label">ID</label>
        <input type="text" class="form-control" name="id">
    </div>

    <div class="mb-3">
        <label class="form-label">Ho Ten</label>
        <input type="text" class="form-control" name="hoTen">
    </div>
    <div class="mb-3">
        <label class="form-label">Dia Chi</label>
        <input type="text" class="form-control" name="diaChi">
    </div>
    <div class="mb-3">
        <label class="form-label">Lop</label>
        <select class="form-select" aria-label="Default select example" name="lop">
            <c:forEach items="${dslh}" var="i">
                <option value="${i.id}">${i.tenLop}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Giới tính</label>
        <br>
        <input type="radio" id="contactChoice1" name="gioiTinh" value="Nam"/>
        <label for="contactChoice1">Nam</label>

        <input type="radio" id="contactChoice2" name="gioiTinh" value="Nu"/>
        <label for="contactChoice2">Nu</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
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
        <td>Action</td>
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
            <td>${sinhVien.lop.tenLop}</td>
            <td><a href="/sinh-vien/detail?id=${sinhVien.id}" class="btn btn-primary">Detail</a>
                <a href="/sinh-vien/delete?vitri=${i.index}" class="btn btn-primary">Xoa</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="row">
    <c:forEach varStatus="i" items="${listSinhVien}" var="sinhVien">
        <div class="col-md-3">
            <div class="thumbnail">
                <a href="/w3images/lights.jpg">
                    <img src="https://product.hstatic.net/1000253775/product/7_0dc9fb936e3c477eaa7ead5ff5f933eb_grande.jpg" alt="Lights" style="width:100%">
                    <div class="caption">
                        <p>${sinhVien.ten}</p>
                    </div>
                </a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
