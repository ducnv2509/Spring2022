package com.example.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;


@MultipartConfig
@WebServlet(name = "UploadServlet", value = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/upload/form.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File dir = new File(request.getServletContext().getRealPath("/files"));
        if(!dir.exists()){
            dir.mkdirs();
        }

        Part photo = request.getPart("photo_file");
        File photoFile = new File(dir, photo.getSubmittedFileName());
        photo.write(photoFile.getAbsolutePath());
        Part doc = request.getPart("doc_file");
        File docFile = new File(dir, doc.getSubmittedFileName());
        doc.write(docFile.getAbsolutePath());


        request.setAttribute("img", photoFile);
        request.setAttribute("doc", docFile);

        request.getRequestDispatcher("/views/upload/result.jsp").forward(request, response);
    }
}
