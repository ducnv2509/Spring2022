package com.example.view3_bt;

import com.example.model.Staff;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@MultipartConfig
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Staff staff = new Staff();
        try {
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("MM/dd/yyyy");
            ConvertUtils.register(dtc, Date.class);

            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            BeanUtils.populate(staff, request.getParameterMap());

            File dir = new File(request.getServletContext().getRealPath("/file"));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part photo = request.getPart("image");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            staff.setImageName(photoFile.getName());
            request.setAttribute("bean", staff);
            request.getRequestDispatcher("/views/register.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }


//        String fullname = request.getParameter("fullname");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String gender = request.getParameter("gender");
//        String address  = request.getParameter("address");
//        String email = request.getParameter("email");
//
//
//        request.setAttribute("fullname", fullname);
//        request.setAttribute("username", username);
//        request.setAttribute("password", password);
//        request.setAttribute("gender", gender);
//        request.setAttribute("address", address);
//        request.setAttribute("email",email);
//        request.setAttribute("phone", request.getParameter("phone"));
//        request.setAttribute("account", request.getParameter("account"));
//
//        request.getRequestDispatcher("/views/register.jsp").forward(request, response);

    }
}
