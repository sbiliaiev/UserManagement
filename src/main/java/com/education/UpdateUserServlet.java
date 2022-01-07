package com.education;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/update")
public class UpdateUserServlet extends HttpServlet {
    private UserDAO userDAO;
    private User user;

    @Override
    public void init() throws ServletException {
        userDAO = UserDAO.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user = userDAO.read(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("user", user);
        request.getRequestDispatcher("/html/update-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user.setName(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));

        userDAO.update(user);

        resp.sendRedirect("/users/list");
    }
}
