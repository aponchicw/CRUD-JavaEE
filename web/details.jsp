<%@ page import="kz.dostyk.db.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DetailsPage</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp" %>
</div>
<div class="container mt-3">
    <div class="row">
        <%
            Users user = (Users) request.getAttribute("user");
            if(user != null){

        %>
        <div class="col-6 mx-auto">
            <div class="jumbotron">
                <h1 class="display-4">
                    <%=user.getName()%>
                </h1>
                <p class="lead">
                    Surname: <%=user.getSurname()%>
                </p>
                <hr class="my-4">
                <p>
                    Country: <%=user.getCountry()%>
                </p>
                <a href="/edituser?id=<%=user.getId()%>" class="btn btn-primary btn-sm">Edit user</a>
            </div>
        </div>
        <%
        } else{
        %>
        <h1 class="text-center">404 - PAGE NOT FOUND</h1>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
