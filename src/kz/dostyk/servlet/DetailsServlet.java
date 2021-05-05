package kz.dostyk.servlet;

import kz.dostyk.db.DBManager;
import kz.dostyk.db.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
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
        request.getRequestDispatcher("/details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
