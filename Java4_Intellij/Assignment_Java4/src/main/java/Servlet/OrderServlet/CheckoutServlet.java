package Servlet.OrderServlet;

import DAO.CustomerDAO.DAO.Cart;
import DAO.CustomerDAO.DAO.Order;
import DAO.CustomerDAO.DAO.OrderDAO;
import DAO.CustomerDAO.connection.DbCon;
import entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "CheckoutServlet", value = "/cart-check-out")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            Users auth = (Users) request.getSession().getAttribute("auth");
            if (cart_list != null && auth != null) {
                for (Cart c : cart_list) {
                    Order order = new Order();
                    order.setId(c.getId());
                    order.setUser_id(auth.getId());
                    order.setQuantity(c.getQuantity());
                    order.setCreated(date);
                    order.setAmount(c.getQuantity());
                    order.setOrderState(1);
                    OrderDAO oDao = new OrderDAO(DbCon.getConnection());
                    boolean result = oDao.insertOrder(order);
                    if (!result) break;
                }
                cart_list.clear();
                response.sendRedirect("/Assignment_Java4_war/ShowOrder");
            } else {
                if (auth == null) {
                    response.sendRedirect("/Assignment_Java4_war/LoginControl");
                } else {
                    response.sendRedirect("/Assignment_Java4_war/ShowCart");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
//        response.sendRedirect("/Assignment_Java4_war/ShowOrder");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
