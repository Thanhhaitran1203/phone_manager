package com.example.controller.controller;

import com.example.controller.model.Phone;
import com.example.controller.service.category.CategoryService;
import com.example.controller.service.phone.PhoneService;
import com.example.controller.service.phone.PhoneServiceJDBC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhoneServlet", urlPatterns = "/")
public class PhoneServlet extends HttpServlet {
    private final PhoneService phoneService = new PhoneServiceJDBC();
    private final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(req,resp);
                break;
            default:
                listPhone(req,resp);
                break;
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
    RequestDispatcher dispatcher = req.getRequestDispatcher("phone/create.jsp");
    req.setAttribute("category",categoryService.fillAll());
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listPhone(HttpServletRequest req, HttpServletResponse resp) {
    List<Phone> phoneList = this.phoneService.fillAll();
    req.setAttribute("phoneList",phoneList);
    RequestDispatcher dispatcher = req.getRequestDispatcher("phone/list.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action  = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createNewPhone(req,resp);
                break;
            default:
                listPhone(req, resp);
        }
    }

    private void createNewPhone(HttpServletRequest req, HttpServletResponse resp) {
    String name = req.getParameter("name");
    int price = Integer.parseInt(req.getParameter("price"));
    String description = req.getParameter("description");
    int categoryId = Integer.parseInt(req.getParameter("category"));
    Phone phone = new Phone(name,price,description);
    phoneService.add(phone,categoryId);
    }
}
