package Servlet.LoginAndRegister.Login;

import DAO.AccountDAO;
import com.cloudinary.provisioning.Account;
import entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginControl", value = "/LoginControl")
public class LoginControl extends HttpServlet {
    AccountDAO accountDAO;

    public LoginControl() {
        accountDAO = new AccountDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/views/LoginAndRegister/Login/login-form-15/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Users a = accountDAO.login(username, password);
        if (a == null) {
            request.setAttribute("message", "Wrong user or password");
            request.getRequestDispatcher("/views/LoginAndRegister/Login/login-form-15/login.jsp").forward(request, response);
        } else {
            response.sendRedirect("/Assignment_Java4_war/HomePage");
        }
    }


}
