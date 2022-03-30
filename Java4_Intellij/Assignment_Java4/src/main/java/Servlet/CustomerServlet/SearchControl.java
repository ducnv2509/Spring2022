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

@WebServlet(name = "SearchControl", value = "/SearchControl")
public class SearchControl extends HttpServlet {
    ListProductsDAO productsDAO;

    public SearchControl() {
        productsDAO = new ListProductsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtSearch = request.getParameter("q");
        List<Products> list = productsDAO.searchProductByName(txtSearch);
        request.setAttribute("listA", list);
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> listC = categoryDAO.findAll();
        request.setAttribute("category", listC);
        request.getRequestDispatcher("/views/Products/List_Products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//        String method = req.getMethod();
//        if (method.equalsIgnoreCase("post")) {
//            String txtSearch = req.getParameter("q");
//            List<Products> list = productsDAO.searchProductByName(txtSearch);
//            req.setAttribute("listA", list);
//            req.getRequestDispatcher("/views/Products/List_Products.jsp").forward(req, resp);
//        }
//    }
}
