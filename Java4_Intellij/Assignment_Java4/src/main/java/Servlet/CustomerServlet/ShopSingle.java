package Servlet.CustomerServlet;

import DAO.ListProductsDAO;
import entity.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet({"/ShopSingle"})
public class ShopSingle extends HttpServlet {
    ListProductsDAO productsDAO;

    public ShopSingle() {
        productsDAO = new ListProductsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String uri = request.getRequestURI();
//        if (uri.contains("show")) {
//        }
//        findIdProduct(request, response);

        request.getRequestDispatcher("/views/Products/detailProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void findIdProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Products products = productsDAO.findByID(id);
        request.setAttribute("product", products);
    }
}