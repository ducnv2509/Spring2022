package com.example.kiemtra_01;

import com.example.model.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ServletJSP", value = "/ServletJSP")
//@WebServlet({"/index", "/create", "/store", "/edit", "/show", "/update", "/delete"})
public class StudentServlet extends HttpServlet {

    List<Student> list = new ArrayList<Student>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student st = new Student(
                "Ph14435", "Nguyễn Văn Đức", true, "udpm", "0332429178", "ducnvph14435@fpt.edu.vn",
                new Date()
        ),
                st2 = new Student(
                        "Ph14436", "Nguyễn Văn Minh", false, "tkw", "09769043277", "okkoo@fpt.edu.vn",
                        new Date()
                );
        list.add(st);
        list.add(st2);
        request.setAttribute("st", list);
        request.setAttribute("view", "views/tableStudent.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
//        String uri = request.getRequestURI();
//        if (uri.contains("index")) {
//            this.index(request, response);
//        } else if (uri.contains("create")) {
//            this.create(request, response);
//        } else {
//            System.out.println("404");
//        }
//        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Student st = new Student(
//                "Ph14435", "Nguyễn Văn Đức", true, "udpm", "0332429178", "ducnvph14435@fpt.edu.vn",
//                new Date()
//        ),
//                st2 = new Student(
//                        "Ph14436", "Nguyễn Văn Minh", false, "tkw", "09769043277", "okkoo@fpt.edu.vn",
//                        new Date()
//                );
//        list.add(st);
//        list.add(st2);
//        request.setAttribute("st", list);
//        request.setAttribute("view", "/views/tableStudent.jsp");
//        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student st = new Student();
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            request.setAttribute("codeStudent", request.getParameter("codeStudent"));
            request.setAttribute("fullName", request.getParameter("fullName"));
            request.setAttribute("gender", request.getParameter("gender"));
            request.setAttribute("major", request.getParameter("major"));
            request.setAttribute("phone", request.getParameter("phone"));
            request.setAttribute("email", request.getParameter("email"));


            st.setCodeStudent(request.getParameter("codeStudent"));
            st.setFullName(request.getParameter("fullName"));
            st.setGender(Boolean.parseBoolean(request.getParameter("gender")));
            st.setEmail(request.getParameter("email"));
            st.setMajor(request.getParameter("major"));
            st.setPhone(request.getParameter("phone"));
            st.setDateCreate(new Date());
            list.add(st);
            BeanUtils.populate(list, request.getParameterMap());
            request.setAttribute("st", list);
            request.getRequestDispatcher("layout.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        String uri = request.getRequestURI();
//        if (uri.contains("store")) {
//            this.store(request, response);
//        } else {
//            System.out.println("404");
//        }
    }

    private void store(HttpServletRequest request, HttpServletResponse response) {
//        Student st = new Student();
//        try {
//            request.setCharacterEncoding("utf-8");
//            response.setCharacterEncoding("utf-8");
//            request.setAttribute("codeStudent", request.getParameter("codeStudent"));
//            request.setAttribute("fullName", request.getParameter("fullName"));
//            request.setAttribute("gender", request.getParameter("gender"));
//            request.setAttribute("major", request.getParameter("major"));
//            request.setAttribute("phone", request.getParameter("phone"));
//            request.setAttribute("email", request.getParameter("email"));

//            st.setCodeStudent(request.getParameter("codeStudent"));
//            st.setFullName(request.getParameter("fullName"));
//            st.setGender(Boolean.parseBoolean(request.getParameter("gender")));
//            st.setEmail(request.getParameter("email"));
//            st.setMajor(request.getParameter("major"));
//            st.setPhone(request.getParameter("phone"));
//            st.setDateCreate(new Date());
//            BeanUtils.populate(list, request.getParameterMap());
//            request.setAttribute("st", list);
//            list.add(st);
//            request.getRequestDispatcher("layout.jsp").forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
