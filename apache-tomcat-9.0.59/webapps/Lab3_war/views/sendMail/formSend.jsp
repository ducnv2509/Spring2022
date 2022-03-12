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
<div class="container" style="margin-top: 10px;">
    <div class="row"
         style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <h2 class="myclass">Information</h2>
            <form action="/Lab3_war/SendMailServlet" method="post">
                <div class="form-group">
                    <label>To:</label>
                    <input type="text"
                           class="form-control" name="to" placeholder="Enter Email">
                </div>
                <div class="form-group">
                    <label>Subject:</label>
                    <input type="text"
                           class="form-control" name="subject" placeholder="Enter Subject">
                </div>
                <div class="form-group">
                    <label for="content">Content:</label>
                    <textarea class="form-control" rows="3"  name="content"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Send</button>
                <button type="reset" class="btn btn-primary">Cancel</button>
            </form>
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