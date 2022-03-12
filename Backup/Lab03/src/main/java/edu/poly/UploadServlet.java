package edu.poly;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/upload/form.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uploadFolder = request.getServletContext().getRealPath("/uploads");
        Path upPath = Paths.get(uploadFolder);

        if (!Files.exists(upPath)) {
            Files.createDirectories(upPath);
        }

        Part imagePart = request.getPart("document");
        Part documentPart = request.getPart("image");

        String imgFileName = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();
        String docFileName = Path.of(documentPart.getSubmittedFileName()).getFileName().toString();

        imagePart.write(Paths.get(upPath.toString(), imgFileName).toString());
        documentPart.write(Paths.get(upPath.toString(), docFileName).toString());

        request.setAttribute("image", imgFileName);
        request.setAttribute("document", docFileName);

//		File dir = new File(request.getServletContext().getRealPath("/files"));
//		if(!dir.exists()) {
//			dir.mkdir();
//		}
//		Part photo = request.getPart("photo_file");
//		File photoFile = new File(dir, photo.getSubmittedFileName());
//		photo.write(photoFile.getAbsolutePath());
//		
//		Part doc = request.getPart("doc_file");
//		File docFile = new File(dir, photo.getSubmittedFileName());
//		doc.write(docFile.getAbsolutePath());
//		
//		request.setAttribute("img", photoFile);
//		request.setAttribute("doc", docFile);
//		

        request.getRequestDispatcher("/views/upload/result.jsp").forward(request, response);
    }

}
