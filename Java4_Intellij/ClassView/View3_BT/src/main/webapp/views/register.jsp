<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<div class="container">
    <div class="row">
        <h1 class="text-center">
            Thông tin đăng ký
        </h1>
        <div class="col-8">
            <form action="RegisterServlet" method="post" enctype="multipart/form-data" >

                <div class="form-group">
                    <label for="">Fullname</label>
                    <input type="text"
                           name="fullname"
                           class="form-control" placeholder="fullname">
                </div>

                <div class="form-group">
                    <label for="">Username</label>
                    <input type="text"
                           name="username"
                           class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="">Password</label>
                    <input type="text"
                           name="password"
                           class="form-control" placeholder="Password">
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
                    <label for="">Address</label>
                    <input type="text"
                           name="address"
                           class="form-control" placeholder="Address">
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
                <div>
                    <label for="">Tài khoản</label>
                    <select name="account" id="">
                        <option value="0">VIP</option>
                        <option value="1">normal</option>
                    </select>
                </div>
                <div class="mt-3">
                    <label for="formFile" class="form-label">Ảnh</label>
                    <input
                            name = "image"
                            class="form-control" type="file" id="formFile">
                </div>
                <button class="btn btn-primary">
                    Submit
                </button>
            </form>


        </div>

        <div class="col-4">
            <ul>
                <li>Image:
                    <img src="/View3_BT_war/file/${bean.imageName}" class="img-fluid" width="150" height="200">
                </li>
                <li>Fullname: ${bean.fullname}</li>
                <li>Username: ${bean.username}</li>
                <li>Password: ${bean.password}</li>
                <li>Gender: ${bean.gender ? 'Nữ' : 'Nam'}</li>
                <li>Address: ${bean.address}</li>
                <li>Email: ${bean.email}</li>
                <li>Phone: ${bean.phone}</li>
                <li>Account: ${bean.account == 1 ? "Normal" : "VIP"}</li>
            </ul>
        </div>
    </div>

</div>
<!-- Bootstrap JavaScript Libraries -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>