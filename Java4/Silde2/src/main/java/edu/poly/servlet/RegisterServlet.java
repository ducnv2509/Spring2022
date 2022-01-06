package edu.poly.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String userName = request.getParameter("username");
            String[] hobbies = request.getParameterValues("hobbies");
            String country = request.getParameter("country");

            out.println("<h1> Username: " + userName + "</h1>");
//			for (int i = 0; i < hobbies.length; i++) {
//				out.println("<li>" + hobbies[i] + "</li>");
//			}
            out.println("<h1>");
            for (String item : hobbies) {
                out.println(item + ", ");
            }
            out.println("</h1>");
            out.print("<h1> Country: " + country + "</h1>");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
