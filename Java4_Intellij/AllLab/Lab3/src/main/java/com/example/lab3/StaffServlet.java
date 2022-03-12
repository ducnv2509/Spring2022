package com.example.lab3;

import com.example.model.staff;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
@MultipartConfig
@WebServlet(name = "StaffServlet", value = "/StaffServlet")
public class StaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/staff/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("MM/dd/yyyy");
            ConvertUtils.register(dtc, Date.class);
            staff staff = new staff();

            BeanUtils.populate(staff, request.getParameterMap());
            File dir = new File(request.getServletContext().getRealPath("/file"));
            if(!dir.exists()){
                dir.mkdirs();
            }
            Part photo = request.getPart("image");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            staff.setImageName(photoFile.getName());
            request.setAttribute("bean", staff);

            request.getRequestDispatcher("/views/staff/form.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
