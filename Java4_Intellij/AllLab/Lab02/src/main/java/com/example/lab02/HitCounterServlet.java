package com.example.lab02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@WebServlet(name = "HitCounterServlet", value = "/HitCounterServlet")
public class HitCounterServlet extends HttpServlet {
    int count;
    Path path = Paths.get("c:/temp/count.txt");

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        count++;
        req.setAttribute("count", count);
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            Files.write(path, String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            count = Integer.parseInt(Files.readAllLines(path).get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/param/hit-counter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/param/hit-counter.jsp").forward(request, response);

    }
}
