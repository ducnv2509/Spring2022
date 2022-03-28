<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/27/2022
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="DashboardAdmin" method="post" enctype="multipart/form-data">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="">Chủng loại</label>
                <select name="category_id" class="form-select" aria-label="Default select example">
                    <c:forEach var="i" items="${category}">
                        <option value="${i.id}">${i.nameCategory}</option>
                    </c:forEach>
                    <%--                    <option selected>Open this select menu</option>--%>
                    <%--                    <option value="1">One</option>--%>
                    <%--                    <option value="2">Two</option>--%>
                    <%--                    <option value="3">Three</option>--%>
                </select>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="">Nhà cung cấp</label>
                <select name="supplier_id" class="form-select" aria-label="Default select example">
                    <c:forEach var="i" items="${supplier}">
                        <option value="${i.id}">${i.nameSupplier}</option>
                    </c:forEach>
                    <%--                    <option selected>Open this select menu</option>--%>
                    <%--                    <option value="1">One</option>--%>
                    <%--                    <option value="2">Two</option>--%>
                    <%--                    <option value="3">Three</option>--%>
                </select>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-6">
            <div class="form-group">
                <label for="">Tên sản phẩm</label>
                <input type="text" name="nameProduct" class="form-control" value="${product.nameProduct}">
            </div>
        </div>
        <div class="col-6">
            <div class="form-group">
                <label for="">Số lượng</label>
                <input type="number" min="1" name="quantity" class="form-control"
                       value="${product.quantity}"
                >
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="">Đơn Giá</label>
                <input type="number" min="100" name="price" class="form-control" value="${product.price}">
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="">Màu</label>
                <input type="text" name="color" class="form-control" value="${product.color}">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="">Size</label>
                <input type="text" name="size" class="form-control" value="${product.size}">
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="">Mô tả chi tiết</label>
                <textarea name="description" class="form-control" id="exampleFormControlTextarea1"
                          rows="3">${product.description}</textarea>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="formFile">Image</label>
                <input class="form-control" type="file" id="formFile" name="imageProduct" value="${product.imageProduct}">
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="">Title</label>
                <input type="text" name="title" class="form-control" value="${product.title}">
            </div>
        </div>
    </div>
    <div class="form-check mt-4">
        <button class="btn btn-primary" formaction="DashboardAdmin/listProduct">Create</button>
        <button class="btn btn-warning" formaction="UserServlet/update?id=${user.id}">Update
        </button>
        <button class="btn btn-danger" formaction="UserServlet/delete?id=${user.id}">Delete</button>
        <button class="btn btn-info" formaction="UserServlet/reset">Reset</button>
    </div>
</form>