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
						<form action="RegisterServlet" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label for="username">Username</label> <input type="text"
									id="username" name="username" class="form-control">
							</div>


							<div class="form-group">
								<label for="pass">Password</label> <input type="password"
									id="pass" name="password" class="form-control">
							</div>

							<div class="form-group">
								<label for="dateOfBirth">Ngay Sinh</label> <input type="date"
									id="dateOfBirth" name="dateOfBirth" class="form-control">
							</div>

							<div class="custom-file mb-4">
								<label for="image" class="custom-file-label">Hinh</label> <input
									type="file" id="image" name="imageName" name="dateOfBirth"
									class="custom-file-input">
							</div>

							<div class="form-group">
								<label for="gender">GioiTinh</label>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input" id="genderM"
										name="gender" value="true" /> <label for="genderM">Male</label>
								</div>

								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input" id="gendeFr"
										name="gender" value="false" /> <label for="genderF">Female</label>
								</div>
							</div>

							<div class="form-group">
								<div class="form-check">

									<input type="checkbox" class="form-check-input" name="married"
										value="true" /> <label for="married">Da co gia dinh
										chua</label>
								</div>
							</div>

							<div class="form-group">
								<label for="nationality">Quoc tich</label> <select
									name="nationality" class="form-control">
									<option>Viet Nam</option>
									<option>My</option>
									<option>Nhat</option>
								</select>
							</div>

							<div class="form-group">
								<label for="favorites">So Thich</label>
								<div class="form-check form-check-inline">
									<input type="checkbox" class="form-check-input"
										name="favorites" id="read" value="read" /> <label for="red">Doc
										Sach</label>
								</div>

								<div class="form-check form-check-inline">
									<input type="checkbox" class="form-check-input"
										name="favorites" id="music" value="music" /> <label
										for="music">Am nhac</label>
								</div>

								<div class="form-check form-check-inline">
									<input type="checkbox" class="form-check-input"
										name="favorites" id="tourist" value="tourist" /> <label
										for="tourist">Du lich</label>
								</div>

								<div class="form-check form-check-inline">
									<input type="checkbox" class="form-check-input"
										name="favorites" id="orthers" value="orthers" /> <label
										for="orthers">Khac</label>
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

					<li><img alt="" src="images/${staff.imageName}"
						class="img-fluid" width="150"></li>
					<li>Ten Dang Nhap: ${staff.username}</li>
					<li>NgaySinh: ${staff.dateOfBirth}</li>
					<li>Mat Khau: ${staff.password}</li>
					<li>gioitinh: ${staff.gender ? 'Nam' : 'Nu'}</li>
					<li>Lap gia dinh ${staff.married ? 'Da Lap Gia Dinh' : 'Chua Lap Gia Dinh'}</li>
					<li>QUoc tich: ${staff.nationality}</li>
					<li>So Thich: ${staff.favorites}</li>
					<li>Ghi Chu: ${staff.note}</li>
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