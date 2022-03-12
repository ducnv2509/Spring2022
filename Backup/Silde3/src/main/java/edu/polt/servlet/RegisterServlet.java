package edu.polt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
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

import edu.polt.model.Student;

@MultipartConfig
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
//			String name = request.getParameter("name");
//			String gender = request.getParameter("gender");
//			String country = request.getParameter("country");

            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("dd/MM/yyyy");
            ConvertUtils.register(dtc, Date.class);

            Student student = new Student();
            BeanUtils.populate(student, request.getParameterMap());

            Part part = request.getPart("imageName");

            String realPart = request.getServletContext().getRealPath("/images");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();

            if (!Files.exists(Path.of(realPart))) {
                Files.createDirectory(Path.of(realPart));

            }
            part.write(realPart + "/" + filename);

            try (PrintWriter out = response.getWriter()) {
                out.println("<h1> Name: " + student.getName() + "</h1>");
                out.println("<h1> Gender: " + student.getGender() + "</h1>");
                out.println("<h1> Country: " + student.getCountry() + "</h1>");
                out.println("<h1> Date: " + student.getDob() + "</h1>");
                out.println("<img src = 'images/" + filename + "' width = '80' height = '80'>");
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
