package com.example.lab02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DangKyServlet", value = "/DangKyServlet")
public class DangKyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/dang-ky/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String use = request.getParameter("username");
        String pass  = request.getParameter("password");
        String gender = request.getParameter("gender");
        String married = request.getParameter("married");
        String country = request.getParameter("country");

        String[] favorites = request.getParameterValues("favorites");
        String notes = request.getParameter("notes");

        request.setAttribute("username", use);
        request.setAttribute("password", pass);
        request.setAttribute("gender", gender);
        request.setAttribute("married", married);
        request.setAttribute("country", country);
        StringBuilder sb = new StringBuilder();
        for (String st: favorites){
            sb.append(st).append(", ");
        }
        request.setAttribute("favorites", sb.toString());
        request.setAttribute("notes", notes);
        request.getRequestDispatcher("/views/dang-ky/form.jsp").forward(request, response);


    }
}
