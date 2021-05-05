<%@ page import="kz.dostyk.db.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditUserPage</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp" %>
</div>
<div class="container mt-3">
    <div class="row">
        <div class="col-6 mx-auto">
            <%
                Users user = (Users) request.getAttribute("user");
                if(user != null){
            %>
            <form action="/edituser" method="post">
                <input type="hidden" name="id" value="<%=user.getId()%>">
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" name="user_name" placeholder="User Name" class="form-control" value="<%=user.getName()%>">
                </div>
                <div class="form-group">
                    <label>Surname:</label>
                    <input type="text" name="user_surname" placeholder="User Surname" class="form-control" value="<%=user.getSurname()%>">
                </div>
                <div class="form-group">
                    <label>Country:</label>
                    <input type="text" name="user_country" placeholder="User Country" class="form-control" value="<%=user.getCountry()%>">
                </div>

                <div class="form-group">
                    <button class="btn btn-success" type="submit">Save User</button>
                    <button class="btn btn-danger" type="button" data-toggle="modal" data-target="#deleteItemModal">Delete User</button>
                </div>
            </form>
            <div class="modal fade" id="deleteItemModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/deleteuser" method="post">
                            <input type="hidden" name="id" value="<%=user.getId()%>">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">Confirmation Message</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Can you confirm deleting the user?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">NO</button>
                                <button class="btn btn-danger">YES</button>
                            </div>
                        </form>
                    </div>
                </div>
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
