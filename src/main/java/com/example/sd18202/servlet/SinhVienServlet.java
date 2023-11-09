package com.example.sd18202.servlet;

import com.example.sd18202.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/detail"
})
public class SinhVienServlet extends HttpServlet {
    ArrayList<SinhVien> listSinhVien = new ArrayList<>();
    ArrayList<String> dslh = new ArrayList<>();

    public SinhVienServlet() {
        listSinhVien.add(new SinhVien("1", "Nguyen Van A", "Ha Noi", "Nam", "SD12345"));
        listSinhVien.add(new SinhVien("2", "Nguyen Van B", "Ha Noi", "Nu", "SD12355"));
        dslh.add("SD12345");
        dslh.add("SD12355");
        dslh.add("SD12346");
        dslh.add("SD12347");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("/hien-thi")) {
            request.setAttribute("listSinhVien", listSinhVien);
            request.setAttribute("dslh", dslh);
            request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            String id = request.getParameter("id");
            SinhVien sinhVienDetail = new SinhVien();
            for (SinhVien sinhVien : listSinhVien) {
                if (sinhVien.getId().equals(id)) {
                    sinhVienDetail = sinhVien;
                }
            }
            request.setAttribute("sinhVien", sinhVienDetail);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da chay vao post");
    }
}
