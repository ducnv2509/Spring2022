package Servlet;

import DAO.UserDAO;
import enititySQLServer.Users;

public class JpaProgram {
    public static void main(String[] args) {
        Users user = new Users();
        user.setAddress("HN");
        user.setAvatar(null);
        user.setEmail("ducit@gmail.com");
        user.setFullName("Duc Nguyen");
        user.setPassword("123");
        user.setPhone("0976903277");
        UserDAO userDAO = new UserDAO();
        userDAO.insert(user);
        System.out.println("OK");
//        user.set
    }
}
