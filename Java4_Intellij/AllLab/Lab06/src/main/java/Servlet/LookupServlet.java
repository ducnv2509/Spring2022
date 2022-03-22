package Servlet;

import DAO.UserDAO;
import DAO.VideoDAO;
import enitity.Users;
import enitity.Videos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet({"/LookupServlet", "/LookupServlet/search-userID"})
public class LookupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/views/look-up.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI();
        if (uri.contains("search-userID")) {
            searchUserID(request, response);
        }
    }

    private void searchUserID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        if (method.equalsIgnoreCase("POST")) {
            try {
                String userID = request.getParameter("userID");
                UserDAO userDAO = new UserDAO();
                Users user = userDAO.findByID(userID);
                System.out.println("name: " + user.getFullname());
                VideoDAO videoDAO = new VideoDAO();
                List<Videos> fav = videoDAO.findFavoriteVideosUserID(userID);
                request.setAttribute("user", user);
                request.setAttribute("favorites", fav);
            } catch (Exception e) {
            }
            request.getRequestDispatcher("/views/look-up.jsp").forward(request, response);
        }
    }
}
