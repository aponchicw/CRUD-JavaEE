<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.dostyk.db.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp" %>
</div>
<div class="container mt-3">
    <div class="row">
        <div class="col-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <td>User ID</td>
                    <td>User Name</td>
                    <td>User Surname</td>
                    <td>Country</td>
                    <td width="10%">DETAILS</td>
                </tr>
                </thead>
                <tbody>
                <%//вытягиваем данные
                    ArrayList <Users> users = (ArrayList<Users>) request.getAttribute("users");
                    if(users != null){
                        for(Users u : users){
                %>
                <tr>
                    <td><%out.print(u.getId());%></td>
                    <td><%out.print(u.getName());%></td>
                    <td><%out.print(u.getSurname());%></td>
                    <td><%out.print(u.getCountry());%></td>
                    <td><a href="/details?id=<% out.print(u.getId());%>" class="btn btn-primary btn-sm">Details</a></td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
