package kz.dostyk.servlet;

import kz.dostyk.db.DBManager;
import kz.dostyk.db.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/edituser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Long userId = 1L;

        try{
            userId = Long.parseLong(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Users user = DBManager.getUser(userId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/edituser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("user_name");
        String surname = request.getParameter("user_surname");
        String country = request.getParameter("user_country");

        Users user = DBManager.getUser(id);

        if(user != null){
            user.setName(name);
            user.setSurname(surname);
            user.setCountry(country);

            DBManager.saveUser(user);
            response.sendRedirect("/details?id="+id);
        } else{
            response.sendRedirect("/");
        }
    }
}
