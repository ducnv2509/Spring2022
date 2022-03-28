package Servlet;

import DAO.UserDAO;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import entity.Users;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MultipartConfig
@WebServlet({"/UserServlet", "/UserServlet/create", "/UserServlet/update", "/UserServlet/edit", "/UserServlet/delete", "/UserServlet/reset", "/UserServlet/search",
        "/UserServlet/orId", "/UserServlet/orFullName"
})
public class UserServlet extends HttpServlet {

    UserDAO userDAO;

    public UserServlet() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String uri = request.getRequestURI();
        Users user = null;
        if (uri.contains("delete")) {
            delete(request, response);
            user = new Users();
            request.setAttribute("user", user);
        } else if (uri.contains("edit")) {
            edit(request, response);
        } else if (uri.contains("reset")) {
            findAll(request, response);
            user = new Users();
            request.setAttribute("user", user);
        } else if (uri.contains("orId")) {
            orderID(request, response);
        }
        findAll(request, response);
        request.getRequestDispatcher("/views/Users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            insert(request, response);
        } else if (uri.contains("delete")) {
            delete(request, response);
            request.setAttribute("user", new Users());
        } else if (uri.contains("update")) {
            update(request, response);
        } else if (uri.contains("reset")) {
            findAll(request, response);
            request.setAttribute("user", new Users());
        } else if (uri.contains("search")) {
            findKeyword(request, response);
        }
        request.getRequestDispatcher("/views/Users.jsp").forward(request, response);
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


    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
//            UserDAO dao = new UserDAO();
            userDAO.delete(userId);
            request.setAttribute("message", "Delete Success !!!");
            findAll(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void findKeyword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        try {
            if (method.equalsIgnoreCase("post")) {
                UserDAO usersDAO1 = new UserDAO();
                String key = request.getParameter("search");
                List<Users> list = usersDAO1.findKeyword(key);
                request.setAttribute("users", list);
                request.setAttribute("message", "OKKKOKOKO");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) {
        try {
//           String uploadFolder = request.getServletContext().getRealPath("/uploads");
//           Path uploadPath = Paths.get(uploadFolder);
//           if(!Files.exists(uploadPath)){
//               Files.createDirectories(uploadPath);
//           }
//           Part imagePart =request.getPart("avatar");
//           String imageFileName = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();
//           imagePart.write(Paths.get(uploadPath.toString(), imageFileName).toString());

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
//            UserDAO userDAO = new UserDAO();
            userDAO.insert(user);
            request.setAttribute("message", "Insert success !!!");
            System.out.println(dir);
            System.out.println(uploadRuslt.get("url"));
            findAll(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            UserDAO dao = new UserDAO();
            List<Users> list = userDAO.findAll();
            request.setAttribute("users", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void orderID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            UserDAO dao = new UserDAO();
            List<Users> list = userDAO.orId();
            request.setAttribute("users", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }


    final static String CLOUDINARY_URL = "CLOUDINARY_URL=cloudinary://959687882171424:yoa_1l--izubACPSc3gyDXfdLCQ@ducnv2509";

    static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "ducnv2509",
            "api_key", "959687882171424",
            "api_secret", "yoa_1l--izubACPSc3gyDXfdLCQ",
            "secure", true));
}
