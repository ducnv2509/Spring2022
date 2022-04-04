package Servlet.CustomerServlet;

import DAO.ListProductsDAO;
import DAO.OrderDAO;
import entity.Products;
import entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addCart", value = "/addCart")
public class addCart extends HttpServlet {
    OrderDAO orderDAO;
    ListProductsDAO productsDAO;

    public addCart() {
        orderDAO = new OrderDAO();
        productsDAO = new ListProductsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("acc");
        Products p = productsDAO.findByID(id);
        if (users != null) {
            orderDAO.addCart(id);
            request.setAttribute("cart", p);
            request.getRequestDispatcher("/views/Products/order.jsp").forward(request, response);
        } else {
            response.sendRedirect("/Assignment_Java4_war/LoginControl");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
