package com.poly.servlet;

import java.io.IOException;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/param/regis.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String married = request.getParameter("married");
        String natinonality = request.getParameter("natinonality");

        String[] favorites = request.getParameterValues("favorites");
        String note = request.getParameter("note");

        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("gender", gender);
        request.setAttribute("married", married);
        request.setAttribute("natinonality", natinonality);
        StringBuilder sb = new StringBuilder();
        for (String st : favorites) {
            sb.append(st).append(", ");
        }
        request.setAttribute("favorites", sb.toString());
        request.setAttribute("note", note);

        request.getRequestDispatcher("/views/param/regis.jsp").forward(request, response);

    }

}
