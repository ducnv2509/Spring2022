<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/20/2022
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="cl" uri="http://cloudinary.com/jsp/taglib" %>
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
    <base href="/CRUD_Temp_war/">
<%--    <script src="../WEB-INF/sorttable.js"></script>--%>
    <style>
        a.active{
            color: green;
            font-weight: bold;
        }
    </style>
</head>

<body>
<div class="container">
    <img src="" class="img-responsive img-fluid" alt="">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled">Disabled</a>
                    </li>
                </ul>
                <form class="d-flex" method="post">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name = "search">
                    <button class="btn btn-outline-success" type="submit"
                            formaction="UserServlet/search"
                    >Search</button>
                </form>
            </div>
        </div>
    </nav>

    <div class="row">
        <div class="col-md-9">
            <div class="row">
                <div class="col">
                    <div class="table-responsive">
                        <table class="table table-striped sortable">
                            <thead>
                            <tr>
                                <td>
                                    ID
                                </td>
                                <td>FullName</td>
                                <td>Email</td>
                                <td>Phone</td>
                                <td>Address</td>
                                <td>Image</td>
                                <td>&nbsp</td>
                            </tr>
                            </thead>
                            <tbody>
                            <%--                            <form class="d-flex">--%>
                            <%--                                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name = "fullName">--%>
                            <%--                                <button class="btn btn-outline-success" type="submit"--%>
                            <%--                                formaction="UserServlet/search?fullName=${user.fullName}"--%>
                            <%--                                >Search</button>--%>
                            <%--                            </form>--%>
                            <c:forEach var="item" items="${listA}">

                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.fullName}</td>
                                    <td>${item.email}</td>
                                    <td>${item.phone}</td>
                                    <td>${item.address}</td>
                                    <td>
                                            <%--                                                                                    <cl:image src="hkcbg16fa31vcplztvc0.jpg" />--%>
                                            <%--                                        <cl:image src="sample.jpg" alt="Sample Image"/>--%>
                                            <%--                                        <img src="https://res.cloudinary.com/ducnv2509/image/upload/v1648117681/hkcbg16fa31vcplztvc0.jpg" alt="">--%>
                                        <img src="${item.avatar}" class="img-fluid" width="150" height="200">
                                    </td>
                                    <td>
                                        <a href="UserServlet/edit?id=${item.id}">
                                            Edit
                                        </a>
                                        <a href="UserServlet/delete?id=${item.id}">
                                            Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                        <c:forEach begin="1" end ="${endP}" var="i">
                            <a class="${tag == i ? "active" : ""}" href="/CRUD_Temp_war/ListAccount?index=${i}">${i}</a>
                        </c:forEach>

                    </div>
                </div>
            </div>

        </div>

        <div class="col-md-3">
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Email address</label>
                <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>

            <ol class="list-group list-group-numbered">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Subheading</div>
                        Content for list item
                    </div>
                    <span class="badge bg-primary rounded-pill">14</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Subheading</div>
                        Content for list item
                    </div>
                    <span class="badge bg-primary rounded-pill">14</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Subheading</div>
                        Content for list item
                    </div>
                    <span class="badge bg-primary rounded-pill">14</span>
                </li>
            </ol>
        </div>
    </div>

    <footer class="bg-danger text-center mt-5">
        Ducnv2509
    </footer>
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
