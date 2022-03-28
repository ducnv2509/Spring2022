package Service;

import DAO.UserDAO;
import entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListAccount", value = "/ListAccount")
public class ListAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        findAll(request,response);
        request.getRequestDispatcher("/views/ListAccount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/views/ListAccount.jsp").forward(request, response);


    }


    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAO dao = new UserDAO();
            List<Users> list = dao.findAll();
            request.setAttribute("users", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        List<Users> list = dao.pagingAccount(2);
        for (Users u: list
             ) {
            System.out.println(u);
        }
    }

}
