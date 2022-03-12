package com.example.lab02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet({"/tam-giac", "/dien-tich", "/chu-vi"})
public class TamGiacServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/param/tam-giac.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));

        if ((a + b > c) && (a + c > b) && (b + c) > c) {
            double cv = a + b + c;
            String uri = request.getRequestURI();
            if (uri.contains("dien-tich")) {
                double dientich = Math.sqrt(cv * (a + b - c) * (a + c - b) * (b + c - a)) / 4;
                request.setAttribute("message", "Dien tich tam giac la: " + dientich);
            } else {
                request.setAttribute("message", "chu vi tam giac: " + cv);
            }
        } else {
            request.setAttribute("message", "Khong thoa man cac canh cua mot tam giac");
        }
        request.getRequestDispatcher("/views/param/tam-giac.jsp").forward(request, response);

    }
}
