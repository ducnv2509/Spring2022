package com.example.slide2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String hobbies = request.getParameter("hobbies");
            String country = request.getParameter("country");

            out.println("<h1>Username: " + username + "</h1>");
            out.println("<h1>Hobbies: " + hobbies + "</h1>");
            out.println("<h1>Country: " + country + "</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
