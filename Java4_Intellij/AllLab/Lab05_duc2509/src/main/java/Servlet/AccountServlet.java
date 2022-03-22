package Servlet;

import DAO.UserDao;
import entity.ListUsers;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet({"/AccountServlet", "/AccountServlet/sign-up", "/AccountServlet/sign-in", "/AccountServlet/edit-profile",
        "/AccountServlet/sign-out", "/AccountServlet/forgot-password", "/AccountServlet/change-password"})
public class AccountServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        String uri = req.getRequestURI();
        if (uri.contains("sign-in")) {
            this.doSignIn(req, resp);
        } else if (uri.contains("sign-up")) {
            this.doSignUp(req, resp);
        } else if (uri.contains("sign-out")) {
        } else if (uri.contains("forgot-password")) {
        } else if (uri.contains("change-password")) {
        } else if (uri.contains("edit-profile")) {
            this.doEditProfile(req, resp);
        }
    }

    private void doSignIn(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String method = req.getMethod();
        if (method.equalsIgnoreCase("POST")) {
            String id = req.getParameter("username");
            String pw = req.getParameter("password");
            try {
                UserDao dao = new UserDao();
                ListUsers user = dao.findByID(id);
                if(!user.getPassword().equals(pw)) {
                    req.setAttribute("message", "Sai mật khẩu!");
                }
                else {
                    req.setAttribute("message", "Đăng nhập thành công!");
                    req.getSession().setAttribute("user", user);
                }
            } catch (Exception e) {
                req.setAttribute("message", "Sai tên đăng nhập!");
            }

        }
        req.getRequestDispatcher("/views/sign-in.jsp").forward(req, resp);
    }

    private void doSignUp(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String method = req.getMethod();
        if (method.equalsIgnoreCase("POST")) {
            try {
                ListUsers entity = new ListUsers();
                BeanUtils.populate(entity, req.getParameterMap());
                UserDao dao = new UserDao();
                dao.insert(entity);
                req.setAttribute("message", "Đăng ký thành công!");
            } catch (Exception e) {
                req.setAttribute("message", "Lỗi đăng ký!");
            }
        }
        req.getRequestDispatcher("/views/sign-up.jsp").forward(req, resp);
    }

    private void doEditProfile(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ListUsers user = (ListUsers) req.getSession().getAttribute("user");
        String method = req.getMethod();
        if (method.equalsIgnoreCase("POST")) {
            try {
                BeanUtils.populate(user, req.getParameterMap());
                UserDao dao = new UserDao();
                dao.update(user);
                req.setAttribute("message", "Cập nhật tài khoản thành công!");
            } catch (Exception e) {
                req.setAttribute("message", "Lỗi cập nhật tài khoản!");
            }
        }
        req.getRequestDispatcher("/views/edit-profile.jsp").forward(req, resp);
    }

}
