package edu.poly.Servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import edu.poly.model.Staff;

@MultipartConfig
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/staffs/form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Staff staff = new Staff();

			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("MM//dd/yyyy");
			ConvertUtils.register(dtc, Date.class);
			BeanUtils.populate(staff, request.getParameterMap());

			String uploadFolder = request.getServletContext().getRealPath("/images");
			Path uploadPath = Paths.get(uploadFolder);

			if (!Files.exists(uploadPath)) {
				Files.createDirectory(uploadPath);
			}
			Part imagePart = request.getPart("imageName");
			String imageFileName = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();
			imagePart.write(Paths.get(uploadPath.toString(), imageFileName).toString());
			staff.setImageName(imageFileName);
			request.setAttribute("staff", staff);
			request.getRequestDispatcher("/staffs/form.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
