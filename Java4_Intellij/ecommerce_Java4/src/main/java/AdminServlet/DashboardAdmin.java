package AdminServlet;

import DAO.AccountDAO;
import DAO.CategoryDAO;
import DAO.ProductsDAO;
import DAO.SupplierDAO;
import Utils.EncryptUtils;
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
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@MultipartConfig
@WebServlet({"/DashboardAdmin", "/DashboardAdmin/mnProducts", "/DashboardAdmin/mnCategory", "/DashboardAdmin/mnSupplier",
        "/DashboardAdmin/index", "/DashboardAdmin/mnAccount", "/DashboardAdmin/storeP", "/DashboardAdmin/updateP",
        "/DashboardAdmin/deleteP", "/DashboardAdmin/storeC", "/DashboardAdmin/updateC", "/DashboardAdmin/deleteC",
        "/DashboardAdmin/storeS", "/DashboardAdmin/updateS", "/DashboardAdmin/deleteS", "/DashboardAdmin/storeA", "/DashboardAdmin/updateA",
        "/DashboardAdmin/deleteA"
})
public class DashboardAdmin extends HttpServlet {
    ProductsDAO productsDAO;
    CategoryDAO categoryDAO;
    SupplierDAO supplierDAO;
    AccountDAO accountDAO;

    public DashboardAdmin() {
        productsDAO = new ProductsDAO();
        categoryDAO = new CategoryDAO();
        supplierDAO = new SupplierDAO();
        accountDAO = new AccountDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("index")) {
            request.setAttribute("views", "/views/dashboardAdmin/component/baseLayout.jsp");
        } else if (uri.contains("mnCategory")) {
            fillCategory(request, response);
            request.setAttribute("views", "/views/dashboardAdmin/ManagerCategory/CRUD_Category.jsp");
        } else if (uri.contains("mnSupplier")) {
            fillSupplier(request, response);
            request.setAttribute("views", "/views/dashboardAdmin/ManagerSupplier/CRUD_Supplier.jsp");
        } else if (uri.contains("mnAccount")) {
            fillAccount(request, response);
            request.setAttribute("views", "/views/dashboardAdmin/ManagerAccount/CRUD_Account.jsp");
        } else if (uri.contains("mnProducts")) {
            fillProducts(request, response);
            fillCategoryAndSupplier(request, response);
            request.setAttribute("views", "/views/dashboardAdmin/ManagerProducts/table.jsp");
        }

        request.getRequestDispatcher("/views/dashboardAdmin/layoutDashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("updateP")) {
            try {
                update(request, response);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnProducts");
        } else if (uri.contains("storeP")) {
            insert(request, response);
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnProducts");
        } else if (uri.contains("deleteP")) {
            delete(request, response);
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnProducts");
        } else if (uri.contains("updateA")) {
            updateAccount(request, response);
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnAccount");
        } else if (uri.contains("storeA")) {
            insertAccount(request, response);
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnAccount");
        } else if (uri.contains("deleteA")) {
            deleteAccount(request, response);
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnAccount");
        } else if (uri.contains("updateC")) {
            try {
                updateCategory(request, response);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnCategory");
        } else if (uri.contains("storeC")) {
            try {
                insertCategory(request, response);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnCategory");

        } else if (uri.contains("deleteC")) {
            deleteCategory(request, response);
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnCategory");
        } else if (uri.contains("updateS")) {
            try {
                updateSupplier(request, response);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnSupplier");
        } else if (uri.contains("storeS")) {
            try {
                insertSupplier(request, response);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnSupplier");


        } else if (uri.contains("deleteS")) {
            deleteSupplier(request, response);
            response.sendRedirect("/ecommerce_Java4_war/DashboardAdmin/mnSupplier");
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
            System.out.println("--------------------------------");
            System.out.println(c_id);
            System.out.println(s_id);
            request.setAttribute("message", "Insert success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }

    }

    private void fillProducts(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Products> listP = productsDAO.findAll();
            request.setAttribute("product", listP);
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

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException {
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
            request.setAttribute("product", products);
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        } catch (ServletException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            productsDAO.delete(userId);
            System.out.println("OKKKKKK");
            request.setAttribute("message", "Delete Success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
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

    private void fillCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Category> listP = categoryDAO.findAll();
            request.setAttribute("category", listP);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
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

    public void fillAccount(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Users> listP = accountDAO.findAll();
            request.setAttribute("account", listP);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
    // Account

    private void insertAccount(HttpServletRequest request, HttpServletResponse response) {
        try {
            Users users = new Users();
            users.setCreated(new Date());
            BeanUtils.populate(users, request.getParameterMap());
            String hashed = EncryptUtils.hashPassword(users.getPassword());
            users.setPassword(hashed);
            accountDAO.insert(users);
            request.setAttribute("message", "Insert success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }

    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response) {
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

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            accountDAO.delete(userId);
            request.setAttribute("message", "Delete Success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    // category

    private void insertCategory(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Category category = new Category();
        BeanUtils.populate(category, request.getParameterMap());
        categoryDAO.insert(category);
        request.setAttribute("message", "Insert success !!!");
//        request.setAttribute("category", category);
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Category category = new Category();
        BeanUtils.populate(category, request.getParameterMap());
        categoryDAO.update(category);
        request.setAttribute("message", "Update success !!!");
        request.setAttribute("category", category);
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            categoryDAO.delete(userId);
            request.setAttribute("message", "Delete Success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
    //Supplier

    private void insertSupplier(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Supplier supplier = new Supplier();
        BeanUtils.populate(supplier, request.getParameterMap());
        supplierDAO.insert(supplier);
        request.setAttribute("message", "Insert success !!!");
//        request.setAttribute("category", category);
    }

    private void updateSupplier(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Supplier supplier = new Supplier();
        BeanUtils.populate(supplier, request.getParameterMap());
        supplierDAO.update(supplier);
        request.setAttribute("message", "Update success !!!");
//        request.setAttribute("category", s);
    }

    private void deleteSupplier(HttpServletRequest request, HttpServletResponse response) {
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
