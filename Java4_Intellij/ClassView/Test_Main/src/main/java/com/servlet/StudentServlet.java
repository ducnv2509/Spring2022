package com.servlet;

import com.enity.Student;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    List<Student> list;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("StudentServlet")) {
            this.index(request, response);
        }

    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("form", "./formCreate.jsp");
        request.setAttribute("view", "./tableStudent.jsp");
        request.getRequestDispatcher("views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("StudentServlet")) {
            try {
                Student student = new Student();
                BeanUtils.populate(student, request.getParameterMap());
                list.add(student);
                request.setAttribute("student", list);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.index(request, response);
        }
    }


    @Override
    public void init() throws ServletException {
        super.init();
        list = new ArrayList<>();

    }

    @Override
    public void destroy() {
        list = null;

    }
}
