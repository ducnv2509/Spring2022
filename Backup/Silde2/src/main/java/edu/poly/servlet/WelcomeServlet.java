package edu.poly.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet(urlPatterns = {"/welcome", "/hello", "/hi"})
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.print("doGet: welcome");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.print("doPost: welcome");
        }
    }

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resq) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		super.service(req, resq);
//		resq.setContentType("text/html");
//		try(PrintWriter out = resq.getWriter()){
//			out.print("Service: welcome");
//		}
//	}


}
