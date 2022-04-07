<%@ page import="java.text.DecimalFormat" %>
<%@ page import="entity.Users" %>
<%@ page import="DAO.CustomerDAO.DAO.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CustomerDAO.DAO.OrderDAO" %>
<%@ page import="DAO.CustomerDAO.connection.DbCon" %>
<%@ page import="DAO.CustomerDAO.DAO.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/29/2022
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    Users auth = (Users) request.getSession().getAttribute("auth");
    List<Order> orders = null;
    if (auth != null) {
        request.setAttribute("auth", auth);
        orders = new OrderDAO(DbCon.getConnection()).userOrders(auth.getId());
    } else {
        response.sendRedirect("/Assignment_Java4_war/LoginControl");
    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
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
</head>

<body>
<!-- Start Top Nav -->
<jsp:include page="info.jsp"/>
<!-- Close Top Nav -->


<!-- Header -->
<jsp:include page="header.jsp"/>
<%--code here--%>


<div class="container">
    <div class="card-header my-3">All Orders</div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Date</th>
            <th scope="col">Name</th>
            <th scope="col">Category</th>
            <th scope="col">Quantity</th>
            <th scope="col">Price</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>

        <%
            if (orders != null) {
                for (Order o : orders) {%>
        <tr>
            <td><%=o.getCreated() %>
            </td>
            <td><%=o.getNameProduct() %>
            </td>
            <td><%=o.getCategoryId() %>
            </td>
            <td><%=o.getQuantity() %>
            </td>
            <td><%=dcf.format(o.getPrice()) %>
            </td>
            <td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getId()%>">Cancel Order</a></td>
        </tr>
        <%
                }
            }
        %>

        </tbody>
    </table>
</div>


<jsp:include page="footerDetails.jsp"/>
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
