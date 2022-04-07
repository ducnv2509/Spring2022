<%@ page import="java.text.DecimalFormat" %>
<%@ page import="entity.Users" %>
<%@ page import="DAO.CustomerDAO.DAO.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CustomerDAO.DAO.ProductDAO" %>
<%@ page import="DAO.CustomerDAO.connection.DbCon" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    Users auth = (Users) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);

    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
        ProductDAO pDao = new ProductDAO(DbCon.getConnection());
        cartProduct = pDao.getCartProducts(cart_list);
        double total = pDao.getTotalCartPrice(cart_list);
        request.setAttribute("cart_list", cart_list);
        request.setAttribute("total", total);
    }
%>


<!DOCTYPE html>
<html lang="en">

<head>
    <title>Zay Shop - Product Detail Page</title>
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

    <!-- Slick -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.servletContext.contextPath}/views/assets/css/slick.min.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.servletContext.contextPath}/views/assets/css/slick-theme.css">
    <!--


    TemplateMo 559 Zay Shop

    https://templatemo.com/tm-559-zay-shop

    -->
    <style>
        .table tbody td {
            vertical-align: middle;
        }

        .btn-incre, .btn-decre {
            box-shadow: none;
            font-size: 25px;
        }
    </style>
</head>

<body>
<!-- Start Top Nav -->
<%--<jsp:include page="info.jsp"/>--%>
<%@include file="info.jsp" %>
<!-- Close Top Nav -->


<!-- Header -->
<%--<jsp:include page="header.jsp"/>--%>
<%@include file="header.jsp" %>
<%--code here--%>
<div class="container my-3">
    <div class="d-flex py-3">
        <h3>Total Price: $
            ${(total>0)?dcf.format(total):0}

        </h3>

                <form action="cart-check-out" method="post">
                    <button type="submit" class="btn btn-primary">
                        Checkout
                    </button>
                </form>
<%--        <a class="mx-3 btn btn-primary"--%>
<%--           href="cart-check-out">Check--%>
<%--            Out</a></div>--%>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Category</th>
            <th scope="col">Price</th>
            <th scope="col">Buy Now</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (cart_list != null) {
                for (Cart c : cartProduct) {
        %>
        <tr>
            <td><%=c.getNameProduct()%>
            </td>
            <td><%=c.getCategoryId()%>
            </td>
            <td>
                <%= dcf.format(c.getPrice())%>
            </td>
            <td>
                <form action="order-now" method="get" class="form-inline">
                    <input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
                    <div class="form-group d-flex justify-content-between">
                        <a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i
                                class="fas fa-plus-square"></i></a>
                        <input type="text" name="quantity" class="form-control" value="<%=c.getQuantity()%>"
                               readonly>
                        <a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i
                                class="fas fa-minus-square"></i></a>
                    </div>
                    <button type="submit" class="btn btn-primary btn-sm">Buy</button>
                </form>
            </td>
            <td><a href="remove-from-cart?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
        </tr>

        <%
                }
            }%>
        </tbody>
    </table>
</div>

<%--<jsp:include page="footerDetails.jsp"/>--%>
<%@include file="footerDetails.jsp" %>
<!-- End Footer -->

<!-- Start Script -->
<script src="${pageContext.servletContext.contextPath}/views/assets/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/views/assets/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/views/assets/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/views/assets/js/templatemo.js"></script>
<script src="${pageContext.servletContext.contextPath}/views/assets/js/custom.js"></script>
<!-- End Script -->

<!-- Start Slider Script -->

<script src="${pageContext.servletContext.contextPath}/views/assets/js/slick.min.js"></script>
<script>
    $('#carousel-related-product').slick({
        infinite: true,
        arrows: false,
        slidesToShow: 4,
        slidesToScroll: 3,
        dots: true,
        responsive: [{
            breakpoint: 1024,
            settings: {
                slidesToShow: 3,
                slidesToScroll: 3
            }
        },
            {
                breakpoint: 600,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 3
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 3
                }
            }
        ]
    });
</script>
<!-- End Slider Script -->

</body>

</html>
