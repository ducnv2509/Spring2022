package com.example.lab01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TinhServlet", value = "/TinhServlet")
public class TinhServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/TinhToan/form.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cd = request.getParameter("cd");
        String cr = request.getParameter("cr");
        double dientich = Double.parseDouble(cd) * Double.parseDouble(cr);
        double chuvi = (Double.parseDouble(cd) + Double.parseDouble(cr)) * 2;
        request.setAttribute("ChuVi", chuvi);
        request.setAttribute("DienTich", dientich);
        request.getRequestDispatcher("views/TinhToan/output.jsp").forward(request,response);
    }
}
