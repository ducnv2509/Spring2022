<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/27/2022
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="DashboardAdmin" value="/DashboardAdmin"/>

<%--<a class="btn btn-primary" href="${DashboardAdmin}/createProduct" role="button">Thêm mới</a>--%>
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    Thêm mới
</button>

<!-- Modal -->
<div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
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
                                <input type="text" name="nameProduct" class="form-control" value="">
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <label for="">Số lượng</label>
                                <input type="number" min="1" name="quantity" class="form-control"
                                       value=""
                                >
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">Đơn Giá</label>
                                <input type="number" min="100" name="price" class="form-control" value="">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">Màu</label>
                                <input type="text" name="color" class="form-control" value="">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">Size</label>
                                <input type="text" name="size" class="form-control" value="">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">Mô tả chi tiết</label>
                                <textarea name="description" class="form-control" id="exampleFormControlTextarea1"
                                          rows="3"></textarea>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="formFile">Image</label>
                                <input class="form-control" type="file" id="formFile" name="imageProduct" value="">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">Title</label>
                                <input type="text" name="title" class="form-control" value="">
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
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<div class="card mb-4">
    <div class="row">
        <div class="col">
            <c:if test="${not empty message}">
                <div class="alert alert-success">${message}</div>

            </c:if>
            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>
        </div>
    </div>
    <div class="card-header">
        <i class="fas fa-table me-1"></i>
        DataTable Example
    </div>
    <div class="card-body">
        <form action="DashboardAdmin">
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Đơn Giá</th>
                    <th>Màu</th>
                    <th>Size</th>
                    <th>Ảnh</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>ID</th>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Đơn Giá</th>
                    <th>Màu</th>
                    <th>Size</th>
                    <th>Ảnh</th>
                    <th>Actions</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach items="${product}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.nameProduct}</td>
                        <td>${product.quantity}</td>
                        <td>${product.price}</td>
                        <td>${product.color}</td>
                        <td>${product.size}</td>
                        <td>
                            <img src="${product.imageProduct}" class="img-fluid" width="50px" alt="">
                        </td>
                        <td>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#exampleModal_edit${product.id}"
                            >
                                sửa
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal_edit${product.id}" tabindex="-1"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel_edit">Modal title</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <form action="DashboardAdmin" method="post" enctype="multipart/form-data">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="">Chủng loại</label>
                                                            <select name="category_id" class="form-select"
                                                                    aria-label="Default select example">
                                                                <c:forEach var="i" items="${category}">
                                                                    <c:if test="${i.id == product.categoryByCategoryId.id}">
                                                                        <option value="${i.id}"
                                                                                selected>${i.nameCategory}</option>
                                                                    </c:if>
                                                                    <c:if test="${i.id != product.categoryByCategoryId.id}">
                                                                        <option value="${i.id}"
                                                                                selected>${i.nameCategory}</option>
                                                                    </c:if>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="">Nhà cung cấp</label>
                                                            <select name="supplier_id" class="form-select"
                                                                    aria-label="Default select example">
                                                                <c:forEach var="i" items="${supplier}">
                                                                    <c:if test="${i.id == product.supplierBySupplierId.id}">
                                                                        <option value="${i.id}"
                                                                                selected>${i.nameSupplier}</option>
                                                                    </c:if>
                                                                    <c:if test="${i.id != product.supplierBySupplierId.id}">
                                                                        <option value="${i.id}"
                                                                                selected>${i.nameSupplier}</option>
                                                                    </c:if>
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
                                                            <input type="text" name="nameProduct" class="form-control"
                                                                   value="${product.nameProduct}">
                                                        </div>
                                                    </div>
                                                    <div class="col-6">
                                                        <div class="form-group">
                                                            <label for="">Số lượng</label>
                                                            <input type="number" min="1" name="quantity"
                                                                   class="form-control"
                                                                   value="${product.quantity}"
                                                            >
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="">Đơn Giá</label>
                                                            <input type="number" min="100" name="price"
                                                                   class="form-control" value="${product.price}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="">Màu</label>
                                                            <input type="text" name="color" class="form-control"
                                                                   value="${product.color}">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="">Size</label>
                                                            <input type="text" name="size" class="form-control"
                                                                   value="${product.size}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="">Mô tả chi tiết</label>
                                                            <textarea name="description" class="form-control"
                                                                      id="exampleFormControlTextarea1"
                                                                      rows="3">${product.description}</textarea>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="formFile">Image</label>
                                                            <input class="form-control" type="file" id="formFile"
                                                                   name="imageProduct" value="${product.imageProduct}">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="">Title</label>
                                                            <input type="text" name="title" class="form-control"
                                                                   value="${product.title}">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-check mt-4">
                                                    <button class="btn btn-primary"
                                                            formaction="DashboardAdmin/listProduct">Create
                                                    </button>
                                                    <button class="btn btn-warning"
                                                            formaction="DashboardAdmin/update?id=${product.id}">Update
                                                    </button>
                                                    <button class="btn btn-danger"
                                                            formaction="UserServlet/delete?id=${user.id}">Delete
                                                    </button>
                                                    <button class="btn btn-info" formaction="UserServlet/reset">Reset
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                Close
                                            </button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button class="btn btn-danger">Xoá</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>

    </div>
</div>


