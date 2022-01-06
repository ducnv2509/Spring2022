package edu.poly.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.model.CookieUtils;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = CookieUtils.get("username", request);
		String password = CookieUtils.get("password", request);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		if (!username.equals("ducnv")) {
			request.setAttribute("message", "Sai ten dang nhap");

		} else if (password.length() < 6) {
			request.setAttribute("message", "Sai Mat khau");
		} else {
			request.setAttribute("message", "Dang nhap thanh cong");
			int hours = (remember == null) ? 0 : 30 * 24;
			CookieUtils.add("username", username, hours, response);
			CookieUtils.add("password", password, hours, response);
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
