package Servlet.LoginAndRegister.Register;

import DAO.AccountDAO;
import entity.Users;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@WebServlet(name = "SignUpControl", value = "/SignUpControl")
public class SignUpControl extends HttpServlet {
    AccountDAO accountDAO;

    public SignUpControl() {
        accountDAO = new AccountDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("/views/LoginAndRegister/Register/colorlib-regform-26/Register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String re_pass = request.getParameter("re_pass");
        if (!password.equals(re_pass)) {
            response.sendRedirect("Assignment_Java4_war/LoginControl");
        } else {
            Users u = accountDAO.checkAccount(username);
            if (u == null) {
                try {
                    Users users = new Users();
                    BeanUtils.populate(users, request.getParameterMap());
                    users.setAvatar(null);
                    users.setCreated(null);
                    users.setAdmin(false);
                    users.setStatus(true);
                    accountDAO.insert(users);
                    response.sendRedirect("/Assignment_Java4_war/HomePage");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                response.sendRedirect("/Assignment_Java4_war/LoginControl");
            }
        }
    }
}
