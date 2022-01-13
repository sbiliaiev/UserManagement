package com.v2.servlet;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.v2.service.UserDto;
import com.v2.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        long id = Long.parseLong(uri.substring("/users/".length()));

        if (id > 0) {
            try {
                String json = objectMapper.writeValueAsString(service.findById(id));

                response.setStatus(200);
                response.setHeader("Content-Type", "application/json");
                response.getOutputStream().println(json);
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(404);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserServletModel user = objectMapper.readValue(request.getReader(), UserServletModel.class);
            System.out.println(user);
            String json = objectMapper.writeValueAsString(service.createUser(new UserDto(user.getName(), user.getEmail())));

            response.setStatus(201);
            response.setHeader("Content-Type", "application/json");
            response.getOutputStream().println(json);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        long id = Long.parseLong(uri.substring("/users/".length()));

        if (id > 0) {
            try {
                UserServletModel user = objectMapper.readValue(request.getReader(), UserServletModel.class);
                System.out.println(user);
                String json = objectMapper.writeValueAsString(service.updateUser(new UserDto(user.getId(), user.getName(), user.getEmail())));

                response.setStatus(200);
                response.setHeader("Content-Type", "application/json");
                response.getOutputStream().println(json);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        long id = Long.parseLong(uri.substring("/users/".length()));

        if (id > 0) {
            try {
                service.removeUser(id);

                response.setStatus(200);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
