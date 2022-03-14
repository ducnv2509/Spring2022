<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/13/2022
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.0.2 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>

<body>
<div class="container">
    <div class="card" style="width: 18rem;">
        <img src="${pageContext.request.contextPath}/views/image/rose.png" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${item.name}</h5>
            <ul class="list-group">
                <li class="list-group-item">
                    Giá gốc: ${item.price}
                </li>
                <li class="list-group-item">
                    Giá mới: <c:set var="newprice" value="${item.price * (1 - item.discount)}"/>
                    <fmt:formatNumber value="${newprice}"/>
                </li>
                <li class="list-group-item">
                    <c:choose>
                        <c:when test="${newprice < 10}">Giá thấp</c:when>
                        <c:when test="${newprice > 100}">Giá cao</c:when>
                        <c:otherwise>Bình thường</c:otherwise>
                    </c:choose>
                </li>


                <li class="list-group-item">
                    Ngày:   <fmt:formatDate value="${item.date}"/>
                </li>
            </ul>
            <a href="#" class="btn btn-primary mt-3">Go somewhere</a>
        </div>
    </div>
</div>
<!-- Bootstrap JavaScript Libraries -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>

<%--</html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--${item.name}--%>
<%--<strong>${item.price}</strong>--%>
<%--<c:set var="newprice" value="${item.price * (1 - item.discount)}"/>--%>
<%--<fmt:formatNumber value="${newprice}"/>--%>
<%--<c:choose>--%>
<%--    <c:when test="${newprice < 10}">Giá thấp</c:when>--%>
<%--    <c:when test="${newprice > 100}">Giá cao</c:when>--%>
<%--    <c:otherwise>Bình thường</c:otherwise>--%>
<%--</c:choose>--%>
<%--</body>--%>
<%--</html>--%>
