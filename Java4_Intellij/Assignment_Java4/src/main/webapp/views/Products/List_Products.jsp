<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/27/2022
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Zay Shop - Product Listing Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="${pageContext.servletContext.contextPath}/views/assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon"
          href="${pageContext.servletContext.contextPath}/views/assets/img/favicon.ico">

    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/views/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/views/assets/css/templatemo.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/views/assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/views/assets/css/fontawesome.min.css">
    <style>
        .activeC {
            color: red;
        }
    </style>
    <!--

    TemplateMo 559 Zay Shop

    https://templatemo.com/tm-559-zay-shop

    -->
</head>

<body>
<!-- Start Top Nav -->
<jsp:include page="component/info.jsp"/>
<!-- Close Top Nav -->


<!-- Header -->
<jsp:include page="component/header.jsp"/>
<!-- Close Header -->

<!-- Modal -->
<jsp:include page="component/search.jsp"/>


<!-- Start Content -->
<div class="container py-5">
    <div class="row">

        <jsp:include page="component/categories.jsp"/>
        <div class="col-lg-9">
            <jsp:include page="component/chooseGender.jsp"/>
            <div class="row">
                <c:forEach var="i" items="${listA}">
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-0 img-fluid"
                                     src="${i.imageProduct}" width="256" height="256" alt="">
                                <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                    <ul class="list-unstyled">
                                        <li><a class="btn btn-success text-white"
                                               href="/Assignment_Java4_war/detailProduct?id=${i.id}"><i
                                                class="far fa-heart"></i></a></li>
                                        <li><a class="btn btn-success text-white mt-2"
                                               href="/Assignment_Java4_war/detailProduct?id=${i.id}"><i
                                                class="far fa-eye"></i></a></li>
                                        <li><a class="btn btn-success text-white mt-2"
                                               href="/Assignment_Java4_war/detailProduct?id=${i.id}"><i
                                                class="fas fa-cart-plus"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="card-body">
                                <a href="/Assignment_Java4_war/detailProduct?id=${i.id}"
                                   class="h3 text-decoration-none">${i.nameProduct}</a>
                                <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                    <li>M/L/X/XL</li>
                                    <li class="pt-2">
                                        <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                        <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                    </li>
                                </ul>
                                <ul class="list-unstyled d-flex justify-content-center mb-1">
                                    <li>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                    </li>
                                </ul>
                                <p class="text-center mb-0">${i.price} $</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div div="row">
                <ul class="pagination pagination-lg justify-content-end">
                    <c:forEach begin="1" end="${endP}" var="i">
                        <li class="page-item">
                            <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0 text-dark ${tag == i ? "active" : ""}"
                               href="/Assignment_Java4_war/HomePage?index=${i}">${i}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

    </div>
</div>
<!-- End Content -->

<!-- Start Brands -->
<jsp:include page="component/footerAndSection.jsp"/>
<!-- End Footer -->

<!-- Start Script -->
<script src="${pageContext.servletContext.contextPath}/views/assets/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/views/assets/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/views/assets/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/views/assets/js/templatemo.js"></script>
<script src="${pageContext.servletContext.contextPath}/views/assets/js/custom.js"></script>
<!-- End Script -->
</body>

</html>
