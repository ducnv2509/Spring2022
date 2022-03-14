<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/11/2022
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <img src="${pageContext.request.contextPath}/views/image/Banner-AP.png" class="img-responsive img-fluid" alt="">
    <%@include file="menu.jsp" %>

    <div class="row mt-5">
        <div class="col-md-9">
            <div class="row">
                <jsp:include page="item.jsp">
                    <jsp:param name="name" value="Sản phẩm nè"/>
                    <jsp:param name="image" value="rose.png"/>
                </jsp:include>

                <jsp:include page="item.jsp">
                    <jsp:param name="name" value="Sản phẩm nè"/>
                    <jsp:param name="image" value="rose.png"/>
                </jsp:include>
                <jsp:include page="item.jsp">
                    <jsp:param name="name" value="Sản phẩm nè"/>
                    <jsp:param name="image" value="rose.png"/>
                </jsp:include>

                <jsp:include page="item.jsp">
                    <jsp:param name="name" value="Sản phẩm nè"/>
                    <jsp:param name="image" value="rose.png"/>
                </jsp:include>

                <jsp:include page="item.jsp">
                    <jsp:param name="name" value="Sản phẩm nè"/>
                    <jsp:param name="image" value="rose.png"/>
                </jsp:include>
                <jsp:include page="item.jsp">
                    <jsp:param name="name" value="Sản phẩm nè"/>
                    <jsp:param name="image" value="rose.png"/>
                </jsp:include>

            </div>
        </div>


        <div class="col-md-3">
            <%@include file="login.jsp" %>
            <%@include file="category.jsp" %>
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
</html>
