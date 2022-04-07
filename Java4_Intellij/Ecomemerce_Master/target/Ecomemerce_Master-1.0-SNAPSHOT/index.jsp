<%@ page import="connection.DbCon" %>
<%@ page import="techtutorial.Users" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page import="techtutorial.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="techtutorial.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Users auth = (Users) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
    ProductDAO pd = new ProductDAO(DbCon.getConnection());
    List<Product> products = pd.getAllProducts();

    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }
%>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <%@include file="include/header.jsp" %>
</head>
<body>
<%@include file="include/navbar.jsp" %>

<div class="container">
    <div class="card-header my-3">All Products</div>
    <div class="row">
        <%
            if (!products.isEmpty()) {
                for (Product p : products) {
        %>
        <div class="col-md-3 my-3">
            <div class="card w-100">
                <img class="card-img-top"
                     src="${pageContext.servletContext.contextPath}/product-image/<%=p.getImage() %>"
                     alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title"><%=p.getName() %>
                    </h5>
                    <h6 class="price">Price: $<%=p.getPrice() %>
                    </h6>
                    <h6 class="category">Category: <%=p.getCategory() %>
                    </h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a class="btn btn-dark" href="add-to-cart?id=<%=p.getId()%>">Add to Cart</a> <a
                            class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            } else {
                out.println("There is no proucts");
            }
        %>

    </div>
</div>


<% out.println(DbCon.getConnection()); %>
<%@include file="include/footer.jsp" %>

</body>
</html>
