<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/9/2022
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>
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

</head>
<body>
<main class="container">
    <header class="row">
        <div class="col">
            <div class="alert alert-succes">
                <h1>Đăng Ky</h1>
            </div>

        </div>
    </header>
    <section class="row">
        <div class="col-7">
            <div class="row">
                <div class="col">
                    <form action="/Lab02_war/DangKyServlet" method="post">
                        <div class="form-group">
                            <label for="username">Username</label> <input type="text"
                                                                          id="username" name="username"
                                                                          class="form-control">
                        </div>


                        <div class="form-group">
                            <label for="pass">Password</label> <input type="password"
                                                                      id="pass" name="password" class="form-control">
                        </div>

                        <div class="form-group">
                            <label for="gender">GioiTinh</label>
                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input"
                                       value="true"
                                       id="genderM"
                                       name="gender"/> <label for="genderM">Male</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input"
                                       value="false"
                                       id="gendeFr"
                                       name="gender"/> <label for="genderF">Female</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-check">

                                <input type="checkbox" class="form-check-input"
                                       value="true"
                                       name="married"/>
                                <label for="married">Da co gia dinh chua</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="country">Quoc tich</label> <select
                                name="country" class="form-control">
                            <option>Viet Nam</option>
                            <option>My</option>
                            <option>Nhat</option>
                        </select>
                        </div>

                        <div class="form-group">
                            <label for="favorites">So Thich</label>
                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input"
                                       value="DocSach"
                                       name="favorites"/> <label for="favorites">Doc Sach</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input"
                                       value="AmNhac"
                                       name="favorites"/> <label for="favorites">Am nhac</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input"
                                       value="DuLich"
                                       name="favorites"/> <label for="favorites">Du lich</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input"
                                       value="Khac"
                                       name="favorites"/> <label for="favorites">Khac</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="notes">Ghi Chu: </label>
                            <textarea rows="3" cols="" name="notes" class="form-group"></textarea>
                        </div>

                        <hr>

                        <button type="submit" class="btn btn-primary">Dang Ky</button>

                    </form>
                </div>
            </div>
        </div>

        <div class="col-5">
            <h3>Thong Tin Dang Dang Ky</h3>
            <ul>
                <li>Ten Dang Nhap: ${username}</li>
                <li>Mat Khau: ${password}</li>
                <li>gioitinh: ${gender}</li>
                <li>Lap gia dinh ${married}</li>
                <li>QUoc tich: ${country}</li>
                <li>So Thich: ${favorites}</li>
                <li>Ghi Chu: ${notes}</li>
            </ul>
        </div>
    </section>
</main>


<!-- Bootstrap JavaScript Libraries -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>


<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="/Lab02_war/dang-ky" method="post">--%>

<%--    Tên đăng nhập: <input type="text" name="username"> <br>--%>
<%--    Mật khẩu: <input type="password" name="password"> <br>--%>
<%--    Giới tính--%>
<%--    <input type="radio" value="true" name="gender"> Nam--%>
<%--    <input type="radio" value="true" name="gender"> Nữ <br>--%>
<%--    <input type="checkbox" name="married"> Đã có gia đình ? <br>--%>
<%--    Quốc tịch: <select name="country" >--%>
<%--    <option value="VN">Việt nam</option>--%>
<%--    <option value="US">United States</option>--%>
<%--</select> <br>--%>


<%--    Ghi chú: <textarea name="notes" id="" cols="30" rows="3">--%>

<%--</textarea>--%>
<%--    <hr>--%>
<%--    <button>--%>
<%--        Đăng ký--%>
<%--    </button>--%>
<%--</form>--%>

<%--</body>--%>
<%--</html>--%>
