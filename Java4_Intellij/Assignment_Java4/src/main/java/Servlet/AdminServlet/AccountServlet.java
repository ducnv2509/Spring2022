package Servlet.AdminServlet;

import DAO.AccountDAO;
import com.cloudinary.utils.ObjectUtils;
import entity.Products;
import entity.Users;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet({"/AccountServlet", "/AccountServlet/index", "/AccountServlet/register", "/AccountServlet/forgot",
        "/AccountServlet/edit", "/AccountServlet/store", "/AccountServlet/delete", "/AccountServlet/update",
        "/AccountServlet/listAccount"
})
public class AccountServlet extends HttpServlet {
    AccountDAO accountDAO;

    public AccountServlet() {
        accountDAO = new AccountDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("index")) {
            request.setAttribute("views", "/views/admin/component/baseLayout.jsp");
        } else if (uri.contains("login")) {
            request.getRequestDispatcher("/views/admin/Dashboard/ManagerAccount/Login.jsp").forward(request, response);
        } else if (uri.contains("register")) {
            request.getRequestDispatcher("/views/admin/Dashboard/ManagerAccount/Register.jsp").forward(request, response);
        } else if (uri.contains("forgot")) {
            request.getRequestDispatcher("/views/admin/Dashboard/ManagerAccount/ForgotPassword.jsp").forward(request, response);
        } else if (uri.contains("listAccount")) {
            fillAccount(request, response);
            request.setAttribute("views", "/views/admin/Dashboard/ManagerAccount/CRUD_Account.jsp");
        }
        request.getRequestDispatcher("/views/admin/Dashboard/layoutAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            update(request, response);
            response.sendRedirect("/Assignment_Java4_war/AccountServlet/listAccount");
        } else if (uri.contains("store")) {
            insert(request, response);
            response.sendRedirect("/Assignment_Java4_war/AccountServlet/listAccount");
        } else if (uri.contains("delete")) {
            delete(request, response);
            response.sendRedirect("/Assignment_Java4_war/AccountServlet/listAccount");

        }
    }

    public void fillAccount(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Users> listP = accountDAO.findAll();
            request.setAttribute("account", listP);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) {
        try {

            Users users = new Users();
            users.setCreated(new Date());
            BeanUtils.populate(users, request.getParameterMap());
            accountDAO.insert(users);
            request.setAttribute("message", "Insert success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            Users userOld = accountDAO.findByID(Integer.parseInt(request.getParameter("id")));
            Users users = new Users();
            users.setCreated(new Date());
            users.setPassword(userOld.getPassword());
            BeanUtils.populate(users, request.getParameterMap());
            accountDAO.update(users);
            request.setAttribute("message", "Update success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            accountDAO.delete(userId);
            request.setAttribute("message", "Delete Success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
}
