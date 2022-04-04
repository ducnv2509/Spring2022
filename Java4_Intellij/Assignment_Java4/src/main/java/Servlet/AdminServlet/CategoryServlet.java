package Servlet.AdminServlet;

import DAO.CategoryDAO;
import entity.Category;
import entity.Products;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet({"/CategoryServlet", "/CategoryServlet/index", "/CategoryServlet/login", "/CategoryServlet/register", "/CategoryServlet/forgot", "/CategoryServlet/listCategory",
        "/CategoryServlet/store", "/CategoryServlet/update", "/CategoryServlet/edit", "/CategoryServlet/delete"
})
public class CategoryServlet extends HttpServlet {

    CategoryDAO categoryDAO;

    public CategoryServlet() {
        categoryDAO = new CategoryDAO();
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
        } else if (uri.contains("listCategory")) {
//            int id = Integer.parseInt(request.getParameter("id"));
//            int quantity = categoryDAO.getQuantityByCategory(id);
            fillCategory(request, response);
            request.setAttribute("views", "/views/admin/Dashboard/ManagerCategory/CRUD_Category.jsp");
//            request.setAttribute("quantity", quantity);
        }

        request.getRequestDispatcher("/views/admin/Dashboard/layoutAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            try {
                insert(request, response);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/Assignment_Java4_war/CategoryServlet/listCategory");

        } else if (uri.contains("update")) {
            try {
                update(request, response);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/Assignment_Java4_war/CategoryServlet/listCategory");

        } else if (uri.contains("delete")) {
            delete(request, response);
            response.sendRedirect("/Assignment_Java4_war/CategoryServlet/listCategory");
        }

    }


    private void fillCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Category> listP = categoryDAO.findAll();
            request.setAttribute("category", listP);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Category category = new Category();
        BeanUtils.populate(category, request.getParameterMap());
        categoryDAO.insert(category);
        request.setAttribute("message", "Insert success !!!");
//        request.setAttribute("category", category);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Category category = new Category();
        BeanUtils.populate(category, request.getParameterMap());
        categoryDAO.update(category);
        request.setAttribute("message", "Update success !!!");
        request.setAttribute("category", category);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            categoryDAO.delete(userId);
            request.setAttribute("message", "Delete Success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
}
