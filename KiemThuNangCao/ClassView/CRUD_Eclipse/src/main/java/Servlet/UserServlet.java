package Servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import model.Users;

/**
 * Servlet implementation class UserServlet
 */
@MultipartConfig
@WebServlet({ "/UserServlet", "/UserServlet/create", "/UserServlet/update", "/UserServlet/edit", "/UserServlet/delete",
		"/UserServlet/reset" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			request.setAttribute("user", new Users());
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/Users.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			Users user = new Users();
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.update(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "Update Success !!!");
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
			UserDAO dao = new UserDAO();
			dao.delete(userId);
			request.setAttribute("message", "Delete Success !!!");
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

//			File dir = new File(
//					"demo");
//			if (!dir.exists()) {
//				dir.mkdirs();
//			}
//			Part photo = request.getPart("avatar");
//			File photoFile = new File(dir, photo.getSubmittedFileName());
//			photo.write(photoFile.getAbsolutePath());
			String uploadFoder = request.getServletContext().getRealPath("/demos");
	        Path uploadPath = Paths.get(uploadFoder);
	        System.out.println(uploadFoder);

	        if(!Files.exists(uploadPath)) {
	            Files.createDirectory(uploadPath);
	        }

	        Part partImg = request.getPart("avatar");
	        String filename = Path.of(partImg.getSubmittedFileName()).getFileName().toString();
			Users user = new Users();
			user.setAvatar(filename);
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO userDAO = new UserDAO();
			userDAO.insert(user);
			request.setAttribute("message", "Insert success !!!");
//            System.out.println(uploadFolder);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDAO dao = new UserDAO();
			List<Users> list = dao.findAll();
			request.setAttribute("users", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

}
