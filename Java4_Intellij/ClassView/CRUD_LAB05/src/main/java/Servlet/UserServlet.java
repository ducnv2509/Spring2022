package Servlet;

import DAO.UserDAO;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import entity.Users;
import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@MultipartConfig
@WebServlet({"/UserServlet", "/UserServlet/create", "/UserServlet/update", "/UserServlet/edit", "/UserServlet/delete", "/UserServlet/reset", "/UserServlet/search"})
public class UserServlet extends HttpServlet {

    UserDAO userDAO;

    public UserServlet() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String indexPage = request.getParameter("index");
        if(indexPage == null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        UserDAO dao = new UserDAO();
        int count = dao.getTotalAccount();
        int endPage = count/3;
        if(count % 3 != 0){
            endPage++;
        }
        List<Users> list = dao.pagingAccount(index);
        request.setAttribute("listA", list);
        request.setAttribute("endP",endPage);
        request.setAttribute("tag", index);
        findAll(request, response);
        request.getRequestDispatcher("/views/Users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            insert(request, response);
            response.sendRedirect("/CRUD_LAB05_war/UserServlet");
        } else if (uri.contains("edit")) {
            edit(request, response);
        } else if (uri.contains("update")) {
            update(request, response);
            response.sendRedirect("/CRUD_LAB05_war/UserServlet");
        } else if (uri.contains("delete")) {
            delete(request, response);
            response.sendRedirect("/CRUD_LAB05_war/UserServlet");
        }
    }


    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Users> list = userDAO.findAll();
            request.setAttribute("users", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) {
        try {
            File dir = new File("/uploads");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part photo = request.getPart("avatar");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            Users user = new Users();
            Map uploadRuslt = cloudinary.uploader().upload(photoFile, ObjectUtils.emptyMap());
            user.setAvatar(uploadRuslt.get("url").toString());
            BeanUtils.populate(user, request.getParameterMap());
            userDAO.insert(user);
            request.setAttribute("message", "Insert success !!!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            UserDAO dao = new UserDAO();
            Users user = dao.findByID(userId);
            request.setAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            File dir = new File("/uploads");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part photo = request.getPart("avatar");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            Users user = new Users();
            BeanUtils.populate(user, request.getParameterMap());
            Map uploadRuslt = cloudinary.uploader().upload(photoFile, ObjectUtils.emptyMap());
            user.setAvatar(uploadRuslt.get("url").toString());
            userDAO.update(user);
            request.setAttribute("user", user);
            request.setAttribute("message", "Update Success !!!");
            findAll(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }


    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            userDAO.delete(userId);
            request.setAttribute("message", "Delete Success !!!");
            findAll(request, response);
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

}
