package Servlet.CustomerServlet;

import DAO.CategoryDAO;
import DAO.ListProductsDAO;
import DAO.SupplierDAO;
import entity.Category;
import entity.Products;
import entity.Supplier;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "detailProduct", value = "/detailProduct")
public class DetailControl extends HttpServlet {
    ListProductsDAO productsDAO;
    SupplierDAO supplierDAO;

    public DetailControl() {
        productsDAO = new ListProductsDAO();
        supplierDAO = new SupplierDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Products p = productsDAO.getProductByID(id);
        request.setAttribute("detailProduct", p);
        fillSupplier(request, response);
        request.getRequestDispatcher("/views/Products/detailProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void fillSupplier(HttpServletRequest request, HttpServletResponse response) {
        try {
            SupplierDAO supplierDAO = new SupplierDAO();
            List<Supplier> listP = supplierDAO.findAll();
            List<Products> listC = productsDAO.findAll();
            request.setAttribute("supplier", listP);
            request.setAttribute("product", listC);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
}
