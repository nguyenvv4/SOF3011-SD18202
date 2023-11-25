<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 09/11/2023
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
<form method="post" action="/sinh-vien/update?id=${sinhVien.id}">
<%--    <div class="mb-3">--%>
<%--        <label class="form-label">ID</label>--%>
<%--        <input type="text" class="form-control" value="${sinhVien.id}">--%>
<%--    </div>--%>

    <div class="mb-3">
        <label class="form-label">Ho Ten</label>
        <input type="text" class="form-control" value="${sinhVien.ten}" name="ten">
    </div>
    <div class="mb-3">
        <label class="form-label">Dia Chi</label>
        <input type="text" class="form-control" value="${sinhVien.diaChi}" name="diaChi">
    </div>
    <div class="mb-3">
        <label class="form-label">Lop</label>
        <select class="form-select" aria-label="Default select example" name="lop">
            <c:forEach items="${dslh}" var="i">
                <option value="${i.id}" <c:if test="${sinhVien.lop == i.tenLop}"> selected</c:if>
                >${i.tenLop}</option>
            </c:forEach>

        </select>
    </div>
    <div class="mb-3">
        <label class="form-label">Giới tính</label>
        <br>
        <input type="radio" id="contactChoice1" name="gioiTinh" value="Nam"
                <c:if test="${sinhVien.gioiTinh == 'Nam'}"> checked</c:if>
        />
        <label for="contactChoice1">Nam</label>

        <input type="radio" id="contactChoice2" name="gioiTinh" value="Nu"
                <c:if test="${sinhVien.gioiTinh == 'Nu'}"> checked</c:if>
        />
        <label for="contactChoice2">Nu</label>
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
