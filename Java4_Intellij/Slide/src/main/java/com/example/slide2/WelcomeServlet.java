package com.example.slide2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/welcome", "/hello", "/hi"})
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try(PrintWriter out = response.getWriter()){
            out.println("doGet: Welcome to Servlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try(PrintWriter out = response.getWriter()){
            out.println("doPost: Welcome to Servlet");
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        try(PrintWriter out = resp.getWriter()){
            out.println("service: Welcome to Servlet");
        }
    }

}
