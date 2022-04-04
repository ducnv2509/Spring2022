package Servlet.AdminServlet;

import DAO.SupplierDAO;
import entity.Category;
import entity.Supplier;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet({"/SupplierServlet", "/SupplierServlet/edit", "/SupplierServlet/index",
        "/SupplierServlet/store", "/SupplierServlet/update", "/SupplierServlet/delete",
        "/SupplierServlet/login", "/SupplierServlet/register", "/SupplierServlet/forgot",
        "/SupplierServlet/listSupplier"
})
public class SupplierServlet extends HttpServlet {

    SupplierDAO supplierDAO;

    public SupplierServlet() {
        supplierDAO = new SupplierDAO();
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
        } else if (uri.contains("listSupplier")) {
            fillSupplier(request, response);
            request.setAttribute("views", "/views/admin/Dashboard/ManagerSupplier/CRUD_Supplier.jsp");
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
            response.sendRedirect("/Assignment_Java4_war/SupplierServlet/listSupplier");

        } else if (uri.contains("update")) {
            try {
                update(request, response);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/Assignment_Java4_war/SupplierServlet/listSupplier");

        } else if (uri.contains("delete")) {
            delete(request, response);
            response.sendRedirect("/Assignment_Java4_war/SupplierServlet/listSupplier");
        }
    }

    private void fillSupplier(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Supplier> listP = supplierDAO.findAll();
            request.setAttribute("supplier", listP);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Supplier supplier = new Supplier();
        BeanUtils.populate(supplier, request.getParameterMap());
        supplierDAO.insert(supplier);
        request.setAttribute("message", "Insert success !!!");
//        request.setAttribute("category", category);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Supplier supplier = new Supplier();
        BeanUtils.populate(supplier, request.getParameterMap());
        supplierDAO.update(supplier);
        request.setAttribute("message", "Update success !!!");
//        request.setAttribute("category", s);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            supplierDAO.delete(userId);
            request.setAttribute("message", "Delete Success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
}
