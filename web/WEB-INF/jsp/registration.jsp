<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Registration Form</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">

  <!-- Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1PiBAdQ"
          crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
          integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
          crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
          integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
          crossorigin="anonymous"></script>

</head>
<%@include file="header.jsp"%>
<body>

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">

      <form action="/marketplace/registration" method="post">

        <h2>Registration Form</h2>

        <div class="form-group">
          <label for="name">Name:</label>
          <input type="text" name="name" id="name" class="form-control">
        </div>

        <div class="form-group">
          <label for="surname">Surname:</label>
          <input type="text" name="surname" id="surname" class="form-control">
        </div>

        <div class="form-group">
          <label for="contacts">Contacts:</label>
          <input type="text" name="contacts" id="contacts" class="form-control">
        </div>

        <div class="form-group">
          <label for="imageref">Image Reference:</label>
          <input type="text" name="imageref" id="imageref" class="form-control">
        </div>

        <div class="form-group">
          <label for="role">Role:</label>
          <select name="role" id="role" class="form-control">
            <option value="USER">USER</option>
            <option value="VENDOR">VENDOR</option>
          </select>
        </div>

        <div class="form-group">
          <label for="login">Login:</label>
          <input type="text" name="login" id="login" class="form-control">
        </div>

        <div class="form-group">
          <label for="password">Password:</label>
          <input type="password" name="password" id="password" class="form-control">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>

      </form>

    </div>
  </div>
</div>

</body>
</html>