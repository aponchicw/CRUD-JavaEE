package kz.dostyk.servlet;

import kz.dostyk.db.DBManager;
import kz.dostyk.db.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/adduser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("user_name");
        String surname = request.getParameter("user_surname");
        String country = request.getParameter("user_country");

        Users user = new Users();
        user.setName(name);
        user.setSurname(surname);
        user.setCountry(country);

        DBManager.addUser(user);
        response.sendRedirect("/");
    }
}
