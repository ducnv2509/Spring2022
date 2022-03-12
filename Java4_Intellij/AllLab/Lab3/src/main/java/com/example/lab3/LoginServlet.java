package com.example.lab3;

import com.example.model.CokkieUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = CokkieUtils.get("username", request);
        String password = CokkieUtils.get("password", request);
        request.setAttribute("username", username);
        request.setAttribute("password", password);

        request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        if (!username.equalsIgnoreCase("poly")) {
            request.setAttribute("message", "Sai Ten Dang Nhap");
        } else {
            request.setAttribute("message", "Dang nhap thanh cong");
            int houres = (remember == null) ? 0 : 30 * 24;
            CokkieUtils.add("username", username, houres, response);
            CokkieUtils.add("password", username, houres, response);
        }
        request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);

    }
}
