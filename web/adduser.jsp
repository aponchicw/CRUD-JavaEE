<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddUserPage</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp" %>
</div>
<div class="container mt-3">
    <div class="row">
        <div class="col-6 mx-auto">
            <form action="/adduser" method="post">
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" name="user_name" placeholder="User Name" class="form-control">
                </div>
                <div class="form-group">
                    <label>Surname:</label>
                    <input type="text" name="user_surname" placeholder="User Surname" class="form-control">
                </div>
                <div class="form-group">
                    <label>Country:</label>
                    <input type="text" name="user_country" placeholder="User Country" class="form-control">
                </div>
                <div class="form-group">
                    <button class="btn btn-success" type="submit">Add User</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
