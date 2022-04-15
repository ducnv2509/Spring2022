package AdminServlet;

import DAO.AccountDAO;
import DAO.StatusOrderDAO;
import entity.FlowStatus;
import entity.OrderStates;
import entity.Orders;
import entity.Users;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/DashboardAdminOrder", "/DashboardAdminOrder/update", "/DashboardAdminOrder/index"})
public class ManagerOrder extends HttpServlet {
    StatusOrderDAO statusOrderDAO;


    public ManagerOrder() {
        statusOrderDAO = new StatusOrderDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("index")) {
            List<OrderStates> li = statusOrderDAO.findAll();
            request.setAttribute("li", li);
            request.setAttribute("views", "/views/dashboardAdmin/ManagerOrder/tableOrder.jsp");
        }
        request.getRequestDispatcher("/views/dashboardAdmin/layoutDashboard.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("o_id"));
        String st = request.getParameter("statusState");
        System.out.println("--------------------------------");
        System.out.println(st);
        System.out.println(id);
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            statusOrderDAO.updateStatus(Integer.parseInt(st), id);
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdminOrder/index");
            System.out.println("ok");
        }
    }

}
