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

@WebServlet(name = "OrderNow", value = "/order-now")
public class OrderNowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            Users auth = (Users) request.getSession().getAttribute("auth");

            if (auth != null) {
                String productId = request.getParameter("id");
                int productQuantity = Integer.parseInt(request.getParameter("quantity"));
                if (productQuantity <= 0) {
                    productQuantity = 1;
                }
                Order orderModel = new Order();
                orderModel.setId(Integer.parseInt(productId));
                orderModel.setUser_id(auth.getId());
                orderModel.setQuantity(productQuantity);
                orderModel.setCreated(date);

                OrderDAO orderDao = new OrderDAO(DbCon.getConnection());
                boolean result = orderDao.insertOrder(orderModel);
                if (result) {
                    ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
                    if (cart_list != null) {
                        for (Cart c : cart_list) {
                            if (c.getId() == Integer.parseInt(productId)) {
                                cart_list.remove(cart_list.indexOf(c));
                                break;
                            }
                        }
                    }
                    response.sendRedirect("/Assignment_Java4_war/order-now");
                } else {
                    out.println("order failed");
                }
            } else {
                response.sendRedirect("/Assignment_Java4_war/LoginControl");
            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
