<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/22/2022
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <base href="/Lab06_war/">
</head>

<body>
<div class="container">
    <nav class="navbar navbar-light bg-light">
        <div class="container-fluid">

            <a class="navbar-brand">Navbar</a>
            <form class="d-flex">
                <form action="POST">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                           name="userID"
                    >
                    <button class="btn btn-outline-success" type="submit"
                            formaction="LookupServlet/search-userID"
                    >Search
                    </button>
                    <div class="input-group ml-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text" id="btnGroupAddon">Username</div>
                        </div>
                        <input type="text" class="form-control" placeholder="Username" aria-label="Input group example" aria-describedby="btnGroupAddon" value ="${user.fullName}" readonly="readonly">
                    </div>

                    <div class="input-group ml-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text" id="btnGroupAddon">Email</div>
                        </div>
                        <input type="text" class="form-control" placeholder="Email" aria-label="Input group example" aria-describedby="btnGroupAddon" value ="${user.email}" readonly="readonly" style="width: 230px">
                    </div>
                </form>
            </form>
        </div>
    </nav>


    <table class="table table-striped">
        <thead>
        <tr>
            <td>ID</td>
            <td>Title</td>
            <td>Views</td>
            <td>Active</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${favorites}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.title}</td>
                <td>${item.views}</td>
                <td>${item.active ? 'Yes' : 'NO'}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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
