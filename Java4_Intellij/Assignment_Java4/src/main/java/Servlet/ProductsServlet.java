package Servlet;

import DAO.CategoryDAO;
import DAO.ListProductsDAO;
import entity.Category;
import entity.Products;
import entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductsServlet", value = "/ProductsServlet")
public class ProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String indexPage = request.getParameter("index");
        if(indexPage == null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        ListProductsDAO listProductsDAO = new ListProductsDAO();
        int count = listProductsDAO.getTotalProducts();
        int endPage = count/3;
        if(count % 3 != 0){
            endPage++;
        }
        List<Products> list = listProductsDAO.pagingAccount(index);
        request.setAttribute("listA", list);
        request.setAttribute("endP",endPage);
        request.setAttribute("tag", index);
        findAllProducts(request, response);
        request.getRequestDispatcher("/views/Products/List_Products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void findAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ListProductsDAO listProductsDAO = new ListProductsDAO();
            List<Products> listP = listProductsDAO.findAll();
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Category> listC = categoryDAO.findAll();
//            request.setAttribute("products", listP);
            request.setAttribute("category", listC);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

}
