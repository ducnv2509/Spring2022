package Servlet.AdminServlet;

import DAO.CategoryDAO;
import DAO.ListProductsDAO;
import DAO.SupplierDAO;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import entity.Category;
import entity.Products;
import entity.Supplier;
import entity.Users;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@MultipartConfig
@WebServlet({"/DashboardAdmin", "/DashboardAdmin/update", "/DashboardAdmin/index", "/DashboardAdmin/login", "/DashboardAdmin/register", "/DashboardAdmin/forgot", "/DashboardAdmin/listProduct", "/DashboardAdmin/createProduct", "/DashboardAdmin/edit"})
public class DashboardAdmin extends HttpServlet {

    ListProductsDAO productsDAO;

    public DashboardAdmin() {
        productsDAO = new ListProductsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("index")) {
            request.setAttribute("views", "/views/admin/component/baseLayout.jsp");
        } else if (uri.contains("login")) {
            request.getRequestDispatcher("/views/admin/Dashboard/ManagerAccount/Login.jsp").forward(request, response);
        } else if (uri.contains("register")) {
            request.getRequestDispatcher("/views/admin/Dashboard/ManagerAccount/Register.jsp").forward(request, response);
        } else if (uri.contains("forgot")) {
            request.getRequestDispatcher("/views/admin/Dashboard/ManagerAccount/ForgotPassword.jsp").forward(request, response);
        } else if (uri.contains("listProduct")) {
//            edit(request,response);
            fillProducts(request, response);
            fillCategoryAndSupplier(request, response);
            request.setAttribute("views", "/views/admin/Dashboard/ManagerProducts/table.jsp");

        } else if (uri.contains("createProduct")) {
            edit(request, response);
            fillCategoryAndSupplier(request, response);
            request.setAttribute("views", "/views/admin/Dashboard/ManagerProducts/CRUD_Products.jsp");
        } else if (uri.contains("edit")) {
            edit(request, response);
            fillProducts(request, response);
            fillCategoryAndSupplier(request, response);
            request.setAttribute("views", "/views/admin/Dashboard/ManagerProducts/CRUD_Products.jsp");
        }
        request.getRequestDispatcher("/views/admin/Dashboard/layoutAdmin.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("listProduct")) {
            insert(request, response);
        } else if (uri.contains("update")) {
            update(request, response);
        }

    }

    private void insert(HttpServletRequest request, HttpServletResponse response) {
        try {
            File dir = new File("/uploads");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part photo = request.getPart("imageProduct");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            Products products = new Products();
            String category_id = request.getParameter("category_id");
            int c_id = Integer.parseInt(category_id);
            String supplier_id = request.getParameter("supplier_id");
            int s_id = Integer.parseInt(supplier_id);
            products.setCategoryId(c_id);
            products.setSupplierId(s_id);
            Map uploadRuslt = cloudinary.uploader().upload(photoFile, ObjectUtils.emptyMap());
            products.setImageProduct(uploadRuslt.get("url").toString());
            BeanUtils.populate(products, request.getParameterMap());
            productsDAO.insert(products);
            request.setAttribute("message", "Insert success !!!");
            System.out.println(dir);
            System.out.println(uploadRuslt.get("url"));
            System.out.println("" + category_id);
            System.out.println("" + supplier_id);
            fillProducts(request, response);
            request.setAttribute("views", "/views/admin/Dashboard/ManagerProducts/table.jsp");
            request.getRequestDispatcher("/views/admin/Dashboard/layoutAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }

    }

    private void fillCategoryAndSupplier(HttpServletRequest request, HttpServletResponse response) {
        try {
            SupplierDAO supplierDAO = new SupplierDAO();
            List<Supplier> listP = supplierDAO.findAll();
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Category> listC = categoryDAO.findAll();
            request.setAttribute("supplier", listP);
            request.setAttribute("category", listC);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void fillProducts(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Products> listP = productsDAO.findAll();
            System.out.println("dcmmmmmmmmm " + listP.get(0).getCategoryByCategoryId().getId());
            request.setAttribute("product", listP);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            Products products = productsDAO.findByID(userId);
            request.setAttribute("product", products);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }


    static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "ducnv2509",
            "api_key", "959687882171424",
            "api_secret", "yoa_1l--izubACPSc3gyDXfdLCQ",
            "secure", true));


    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            File dir = new File("/uploads");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part photo = request.getPart("imageProduct");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            Products products = new Products();
            String category_id = request.getParameter("category_id");
            int c_id = Integer.parseInt(category_id);
            String supplier_id = request.getParameter("supplier_id");
            int s_id = Integer.parseInt(supplier_id);
            products.setCategoryId(c_id);
            products.setSupplierId(s_id);
            Map uploadRuslt = cloudinary.uploader().upload(photoFile, ObjectUtils.emptyMap());
            products.setImageProduct(uploadRuslt.get("url").toString());
            BeanUtils.populate(products, request.getParameterMap());
            productsDAO.update(products);
            request.setAttribute("message", "update success !!!");
            System.out.println(dir);
            System.out.println(uploadRuslt.get("url"));
            System.out.println("" + category_id);
            System.out.println("" + supplier_id);
            fillProducts(request, response);
            response.sendRedirect("/Assignment_Java4_war/DashboardAdmin/listProduct");
//            request.setAttribute("views", "/views/admin/Dashboard/ManagerProducts/table.jsp");
//            request.getRequestDispatcher("/views/admin/Dashboard/layoutAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }

    }
}
