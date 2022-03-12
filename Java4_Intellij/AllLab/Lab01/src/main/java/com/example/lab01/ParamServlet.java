package com.example.lab01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ParamServlet", value = "/ParamServlet")
public class ParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/param/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("fullName");
        request.setAttribute("message", "Xin Chao" + name);
        request.getRequestDispatcher("views/param/success.jsp").forward(request,response);
    }
}
