package poly;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HinhChuNhat")
public class HinhChuNhat extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/HCN/formHCN.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String x = request.getParameter("dai");
        String y = request.getParameter("rong");
        double dai = Double.parseDouble(x);
        double rong = Double.parseDouble(y);
        double dt = dai * rong;
        double cv = (dai + rong) * 2;
        request.setAttribute("dt", dt);
        request.setAttribute("cv", cv);

        request.getRequestDispatcher("/views/HCN/KetQua.jsp").forward(request, response);

    }

}
