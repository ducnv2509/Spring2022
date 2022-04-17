package ServletCustomer;

import DAO.FavoriteDAO;
import Utils.SaveLogin;
import entity.Favorite;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LikeProduct", value = "/LikeProduct")
public class LikeProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!SaveLogin.isLogin()) {
            response.sendRedirect("/ecommerce_Java4_war/LoginControl");
        } else {
            HttpSession session = request.getSession();
            int idP = Integer.parseInt(request.getParameter("id"));
            FavoriteDAO favoriteDAO = new FavoriteDAO();
            Favorite favorite = new Favorite();
            favorite.setUserId(SaveLogin.user.getId());
            favorite.setProductId(idP);
            favorite.setLikeDate(new Date());
            favoriteDAO.insert(favorite);
            request.setAttribute("like", favoriteDAO.findByIDUser(SaveLogin.user.getId()));
            response.sendRedirect("/ecommerce_Java4_war/HomePage");
            System.out.println("ok");
        }
    }

    public void checkFv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
