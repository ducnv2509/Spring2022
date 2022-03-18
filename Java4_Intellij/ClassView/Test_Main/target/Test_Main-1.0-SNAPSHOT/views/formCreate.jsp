<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/18/2022
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<form action="StudentServlet" method="post">
    <div class="form-group">
        <label for="">Ma Sinh Vien</label>
        <input type="text"
               name="codeStudent"
               class="form-control" placeholder="Ma Sinh Vien">
    </div>

    <div class="form-group">
        <label for="">FullName</label>
        <input type="text"
               name="fullName"
               class="form-control" placeholder="FullName">
    </div>

    <div class="form-group">
        <label for="">Email</label>
        <input type="email"
               name="email"
               class="form-control" placeholder="Email">
    </div>

    <div class="form-group">
        <label for="">Phone</label>
        <input type="text"
               name="phone"
               class="form-control" placeholder="Phone">
    </div>
    <div class="form-group">
        <label>Major</label>
        <select class="form-select" aria-label="Default select example" name="major">
            <option selected>Please select major for me</option>
            <option value="udpm">Ứng dụng phầm mềm</option>
            <option value="tkw">Thiết kế web</option>
            <option value="mobile">Mobile</option>
        </select>
    </div>

    <div class="form-group">
        <label for="gender">GioiTinh</label>
        <div class="form-check form-check-inline">
            <input type="radio" class="form-check-input" id="genderM" name="gender"
                   value="true" checked/> <label for="genderM">Male</label>
        </div>

        <div class="form-check form-check-inline">
            <input type="radio" class="form-check-input" id="gendeFr" name="gender"
                   value="false"/> <label for="genderF">Female</label>
        </div>
    </div>
    <%--    <div class="mt-3">--%>
    <%--        <label for="formFile" class="form-label">Ảnh</label>--%>
    <%--        <input--%>
    <%--                name="image"--%>
    <%--                class="form-control" type="file" id="formFile">--%>
    <%--    </div>--%>
    <button class="btn btn-primary mb-4">
        Submit
    </button>
</form>
