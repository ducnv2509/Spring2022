<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">

    <title>Hello, world!</title>
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
                    <form action="RegisterServlet" method="post">
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
                                <input type="radio" class="form-check-input" id="genderM"
                                       name="gender"/> <label for="genderM">Male</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="radio" class="form-check-input" id="gendeFr"
                                       name="gender"/> <label for="genderF">Female</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-check">

                                <input type="checkbox" class="form-check-input" name="married"/>
                                <label for="married">Da co gia dinh chua</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="natinonality">Quoc tich</label> <select
                                name="natinonality" class="form-control">
                            <option>Viet Nam</option>
                            <option>My</option>
                            <option>Nhat</option>
                        </select>
                        </div>

                        <div class="form-group">
                            <label for="favorites">So Thich</label>
                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input"
                                       name="favorites" value="read"/> <label for="favorites">Doc Sach</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input"
                                       name="favorites" value="music"/> <label for="favorites">Am nhac</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input"
                                       name="favorites" value="Tourist"/> <label for="favorites">Du lich</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input type="checkbox" class="form-check-input"
                                       name="favorites" value="orther"/> <label for="favorites">Khac</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="note">Ghi Chu: </label>
                            <textarea rows="3" cols="" name="note" class="form-control"></textarea>
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
                <li>QUoc tich: ${natinonality}</li>
                <li>So Thich: ${favorites}</li>
                <li>Ghi Chu: ${note}</li>
            </ul>
        </div>
    </section>
</main>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>