package kz.dostyk.servlet;

import kz.dostyk.db.DBManager;
import kz.dostyk.db.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteuser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Users user = DBManager.getUser(id);

        if(user != null){
            DBManager.deleteUser(user);
        }
        response.sendRedirect("/");
    }
}
