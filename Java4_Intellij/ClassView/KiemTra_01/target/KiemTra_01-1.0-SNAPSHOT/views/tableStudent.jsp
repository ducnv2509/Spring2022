<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/18/2022
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<c:if test="${empty st}">
    <p class="alert alert-warning">
        Không có đữ liệu em êi
    </p>
</c:if>

<c:if test="${!empty st}">
    <p class="alert alert-warning">
         có đữ liệu em êi
    </p>
    <div class="table-responsive">
        <table class="table table-hover table-bordered">
            <thead>
            <th>MSV</th>
            <th>FullName</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Major</th>
            <th>PhoneNumber</th>
            <th>Date Create</th>
            </thead>

            <tbody>
            <c:forEach items="${st}" var="user">
                <tr>
                    <td>${user.codeStudent}</td>
                    <td>${user.fullName}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.gender == true}">Nam</c:when>
                            <c:when test="${user.gender == false}">Nữ</c:when>
                        </c:choose>
                    </td>
                    <td>${user.email}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.major == 'udpm'}">Ứng dụng phần mềm</c:when>
                            <c:when test="${user.major == 'tkw'}">Thiết kế Web</c:when>
                            <c:when test="${user.major == 'mobile'}">Mobile</c:when>
                            <c:otherwise>NULL</c:otherwise>
                        </c:choose>

                    </td>
                    <td>${user.phone}</td>

                    <td>
                        <fmt:formatDate value="${user.dateCreate}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</c:if>
