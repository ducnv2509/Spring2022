package Servlet;

import DAO.UserDao;
import entity.ListUsers;
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
        ListUsers user = null;
        if (uri.contains("delete")) {
            delete(request, response);
            user = new ListUsers();
            request.setAttribute("user", user);
        } else if (uri.contains("edit")) {
            edit(request, response);
        } else if (uri.contains("reset")) {
            user = new ListUsers();
            request.setAttribute("user", user);
        }
        findAll(request, response);
        request.getRequestDispatcher("/views/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.insert(request, response);
        } else if (uri.contains("delete")) {
            delete(request, response);
            request.setAttribute("user", new ListUsers());
        } else if (uri.contains("update")) {
            update(request, response);
        } else if (uri.contains("reset")) {
            request.setAttribute("user", new ListUsers());
        }
        findAll(request, response);
        request.getRequestDispatcher("/views/users.jsp").forward(request, response);
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ListUsers user = new ListUsers();
            BeanUtils.populate(user, request.getParameterMap());
            UserDao dao = new UserDao();
            dao.insert(user);
            request.setAttribute("message", "Insert Success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDao dao = new UserDao();
            List<ListUsers> list = dao.findAll();
            request.setAttribute("users", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userId = request.getParameter("userId");
            UserDao dao = new UserDao();
            ListUsers user = dao.findByID(userId);
            request.setAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ListUsers user = new ListUsers();
            BeanUtils.populate(user, request.getParameterMap());
            UserDao dao = new UserDao();
            dao.update(user);
            request.setAttribute("user", user);
            request.setAttribute("message", "Update Success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userId = request.getParameter("userId");
            UserDao dao = new UserDao();
            dao.delete(userId);
            request.setAttribute("message", "Delete Success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
}
