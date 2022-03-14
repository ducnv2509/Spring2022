package com.example.lab04;

import com.example.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = Arrays.asList(new User("Username 1", "Password 1", true),
                new User("Username 2", "Password 2", false),
                new User("Username 3", "Password 3", true));
        request.setAttribute("message", "Quản lý người sử dụng!");
        request.setAttribute("form", users.get(0));
        request.setAttribute("items", users);
        request.getRequestDispatcher("/User/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
