package com.example.lab04;

import com.example.model.Item;
import com.example.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ListProductServlet", value = "/ListProductServlet")
public class ListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = Arrays.asList(new Item("Nokia 2020", "nokia.jpg", 500, 0.1, new Date()),
                new Item("Samsung Xyz", "samsung.jpg", 700, 0.15, new Date()),
                new Item("iPhone Xy", "iphone.jpg", 900, 0.25, new Date()),
                new Item("Sony Erricson", "sony.jpg", 55, 0.3, new Date()),
                new Item("Seamen", "seamen.jpg", 70, 0.5, new Date()),
                new Item("Oppo 2021", "oppo.jpg", 200, 0.2, new Date()));
        request.setAttribute("items", items);
        request.getRequestDispatcher("/User/ListProduct.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
