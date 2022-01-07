package com.education;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/create")
public class CreateUserServlet extends HttpServlet {

    private UserDAO userDAO;

    public CreateUserServlet() {
        System.out.println("Servlet created yoyo!");
    }

    @Override
    public void init() throws ServletException {
        userDAO = UserDAO.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        RequestDispatcher view = request.getRequestDispatcher("/html/create-user.html");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User user = new User(name, email);

        userDAO.create(user);

        response.sendRedirect("/users/list");
    }
}
