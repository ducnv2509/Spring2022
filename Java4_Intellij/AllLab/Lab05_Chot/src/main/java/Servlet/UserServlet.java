package Servlet;

import DAO.UserDAO;
import entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet({"/UserServlet", "/UserServlet/create", "/UserServlet/update", "/UserServlet/edit", "/UserServlet/delete", "/UserServlet/reset"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        User user = null;
        if (uri.contains("delete")) {
            user = new User();
        } else if (uri.contains("edit")) {

        } else if (uri.contains("reset")) {
            user = new User();
            request.setAttribute("users", user);
        }
        findAll(request, response);
        request.getRequestDispatcher("/views/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("insert")) {
            this.insert(request, response);
        } else if (uri.contains("delete")) {

        } else if (uri.contains("update")) {

        } else if (uri.contains("edit")) {

        } else if (uri.contains("reset")) {

        }
        findAll(request, response);
        request.getRequestDispatcher("/views/user.jsp").forward(request, response);
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = new User();
            BeanUtils.populate(user, request.getParameterMap());
            UserDAO dao = new UserDAO();
            dao.insert(user);
            request.setAttribute("message", "Insert Success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAO dao = new UserDAO();
            List<User> list = dao.findAll();
            request.setAttribute("users", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
}
