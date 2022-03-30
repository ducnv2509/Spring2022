package Servlet.CustomerServlet;

import DAO.CategoryDAO;
import DAO.ListProductsDAO;
import entity.Category;
import entity.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryControl", value = "/CategoryControl")
public class CategoryControl extends HttpServlet {
    ListProductsDAO productsDAO;

    public CategoryControl() {
        productsDAO = new ListProductsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Products> list = productsDAO.getProductByIdCategory(id);
        request.setAttribute("listA", list);
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> listC = categoryDAO.findAll();
        request.setAttribute("category", listC);
        request.setAttribute("tag", id);
        request.getRequestDispatcher("/views/Products/List_Products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
