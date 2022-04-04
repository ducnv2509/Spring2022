package Servlet.CustomerServlet;

import DAO.ListProductsDAO;
import entity.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    ListProductsDAO productsDAO;

    public OrderServlet() {
        productsDAO = new ListProductsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Products p = productsDAO.getProductByID(id);
//        request.setAttribute("detailProduct", p);
//        fillSupplier(request, response);
        request.getRequestDispatcher("/views/Products/order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
