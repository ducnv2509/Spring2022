package edu.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServler
 */
@WebServlet("/LifeCycleServler")
public class LifeCycleServler extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    public void destroy() {
        System.out.println("destroy method");
    }


    @Override
    public void init() throws ServletException {
        System.out.println("Init method");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doget method");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dopost method");
    }

}
