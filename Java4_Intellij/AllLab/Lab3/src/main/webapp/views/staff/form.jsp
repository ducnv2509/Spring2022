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
                <h1>Dang Ky</h1>
            </div>

        </div>
    </header>
    <section class="row">
        <div class="col-7">
            <div class="row">
                <div class="col">
                    <form action="/Lab3_war/StaffServlet" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="username">Username</label> <input type="text" id="username" name="username"
                                                                          class="form-control">
                        </div>


                        <div class="form-group">
                            <label for="pass">Password</label> <input type="password" id="pass" name="password"
                                                                      class="form-control">
                        </div>

                        <div class="form-group">
                            <label for="pass">Ngay Sinh</label> <input type="date" id="doB" name="doB"
                                                                       class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="formFile" class="form-label">Hinh</label>
                            <input class="form-control"
                                   name = "image"
                                   type="file" id="formFile">
                        </div>


                        <div class="form-group">
                            <label for="gender">GioiTinh</label>
                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input" id="genderM" name="gender"
                                       value="true"/> <label for="genderM">Male</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input" id="gendeFr" name="gender"
                                       value="false"/> <label for="genderF">Female</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-check">

                                <input type="checkbox" class="form-check-input" name="married" value="true"/>
                                <label for="married">Da co gia dinh
                                    chua</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="natinonality">Quoc tich</label> <select name="country"
                                                                                class="form-control">
                            <option>Viet Nam</option>
                            <option>My</option>
                            <option>Nhat</option>
                        </select>
                        </div>

                        <div class="form-group">
                            <label for="favorites">So Thich</label>
                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input" name="hobbies" value="read"/>
                                <label for="favorites">Doc
                                    Sach</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input" name="hobbies" value="music"/>
                                <label for="favorites">Am
                                    nhac</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input" name="hobbies" value="Tourist"/>
                                <label for="favorites">Du
                                    lich</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input" name="hobbies" value="orther"/>
                                <label for="favorites">Khac</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="note">Ghi Chu: </label>
                            <textarea rows="3" cols="" name="notes" class="form-control"></textarea>
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
                <li><img src="/Lab3_war/file/${bean.imageName}" alt="" class="img-fluid" width="150" height="200"/></li>
                <li>Ten Dang Nhap: ${bean.username}</li>
                <li>Mat Khau: ${bean.password}</li>
                <li>gioitinh: ${bean.gender ? 'Nam' : 'Nu'}</li>
                <li>Lap gia dinh ${bean.married ? 'Da Co Gia Dinh' : 'Chua co gia dinh'}</li>
                <li>QUoc tich: ${bean.country}</li>
                <li>So Thich: ${bean.hobbies}</li>
                <li>Ghi Chu: ${bean.notes}</li>
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