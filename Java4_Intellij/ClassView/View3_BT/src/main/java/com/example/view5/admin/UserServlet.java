package com.example.view5.admin;

import com.example.view5.model.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@WebServlet({"/users/index", "/users/create", "/users/store", "/users/edit", "/users/show", "/users/update", "/users/delete"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("index")) {
            this.index(request, response);
        } else if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("show")) {
            this.show(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> staff = new ArrayList<Staff>();
        Staff o1 = new Staff("admin", "Nguyen van Duc", "123", "ducnvph14435@fpt.edu.vn", "0332429178", "Ha Noi", "ducnv.jpg", true, 1),
                o2 = new Staff("admin12", "Nguyen van 12", "123", "ducn123h14435@fpt.edu.vn", "0332429178", "Ha Noi", "ducnv.jpg", false, 2),
                o3 = new Staff("21131Mna", "Nguyen van 12", "123", "ducn123h14435@fpt.edu.vn", "0332429178", "Ha Noi", "ducnv.jpg", false, 2);

        staff.add(o1);
        staff.add(o2);
        staff.add(o3);
        request.setAttribute("staff", staff);
        request.setAttribute("view", "/views5/admin/user/index.jsp");
        request.getRequestDispatcher("/views5/layout.jsp").forward(request, response);
    }

    private void show(HttpServletRequest request, HttpServletResponse response) {
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            //404
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void store(HttpServletRequest request, HttpServletResponse response) {
    }
}
