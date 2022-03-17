<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/16/2022
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:if test="${empty staff}">
    <p class="alert alert-warning">
        Không có đữ liệu em êi
    </p>
</c:if>

<c:if test="${!empty staff}">
    <div class="table-responsive">
        <table class="table table-hover table-bordered">
            <thead>
            <th>FullName</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Phonenumber</th>
            <th>image</th>
            <th>Address</th>
            <th>Account</th>
            </thead>

            <tbody>
            <c:forEach items="${staff}" var="user">
                <tr>
                    <td>${user.fullname}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.gender == true}">Nam</c:when>
                            <c:when test="${user.gender == false}">Nữ</c:when>
                        </c:choose>
                    </td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.imageName}</td>
                    <td>${user.address}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.account == 1}">VIP</c:when>
                            <c:otherwise>Normal</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</c:if>




