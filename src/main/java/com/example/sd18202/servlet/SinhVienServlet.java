package com.example.sd18202.servlet;

import com.example.sd18202.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = "/sinh-vien/hien-thi")
public class SinhVienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SinhVien> listSinhVien = new ArrayList<>();
        listSinhVien.add(new SinhVien("1", "Nguyen Van A", "Ha Noi", "Nam", "SD12345"));
        listSinhVien.add(new SinhVien("2", "Nguyen Van B", "Ha Noi", "Nu", "SD12355"));


        request.setAttribute("listSinhVien", listSinhVien);

        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da chay vao post");
    }
}
