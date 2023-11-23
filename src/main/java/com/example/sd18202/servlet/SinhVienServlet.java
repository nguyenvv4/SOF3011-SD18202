package com.example.sd18202.servlet;

import com.example.sd18202.model.LopHoc;
import com.example.sd18202.model.SinhVien;
import com.example.sd18202.service.LopHocService;
import com.example.sd18202.service.SinhVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/detail",
        "/sinh-vien/add",
        "/sinh-vien/delete",
        "/sinh-vien/update",
})
public class SinhVienServlet extends HttpServlet {
//    ArrayList<SinhVien> listSinhVien = new ArrayList<>();

    // call service => repo


    SinhVienService sinhVienService = new SinhVienService();
    LopHocService lopHocService = new LopHocService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("/hien-thi")) {
            // lấy list sinh viên từ bên service thông qua hàm getList()
            ArrayList<SinhVien> listSinhVien = sinhVienService.getList();
            request.setAttribute("listSinhVien", listSinhVien);
            ArrayList<LopHoc> dslh = lopHocService.getListLopHoc();

            request.setAttribute("dslh", dslh);
            request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            String id = request.getParameter("id");
            SinhVien sinhVienDetail = new SinhVien();
//            for (SinhVien sinhVien : listSinhVien) {
//                if (sinhVien.getId().equals(id)) {
//                    sinhVienDetail = sinhVien;
//                }
//            }
            request.setAttribute("sinhVien", sinhVienDetail);
//            request.setAttribute("dslh", dslh);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            int vitri = Integer.parseInt(request.getParameter("vitri"));
//            listSinhVien.remove(vitri);
            response.sendRedirect("/sinh-vien/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            // bước 1: lấy thông tin trên form xuống
            String hoTen = request.getParameter("hoTen");
            String diaChi = request.getParameter("diaChi");
            Integer lop = Integer.parseInt(request.getParameter("lop"));
            String gioiTinh = request.getParameter("gioiTinh");
            // bước 2 tạo đối tượng từ thông tin vừa lấy
            SinhVien sinhVien = new SinhVien();
            sinhVien.setDiaChi(diaChi);
            sinhVien.setTen(hoTen);
            sinhVien.setGioiTinh(gioiTinh);
            LopHoc lopHoc = new LopHoc();
            lopHoc.setId(lop);
            sinhVien.setLop(lopHoc);
            // bước 3: add đối tượng vào danh sách
            sinhVienService.addNew(sinhVien);
            // bước 4 quay lại hiển thị
            response.sendRedirect("/sinh-vien/hien-thi");
        } else if (uri.contains("/update")) {
            String id = request.getParameter("id");
            String hoTen = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String lop = request.getParameter("lop");
            String gioiTinh = request.getParameter("gioiTinh");
//            SinhVien sinhVienNew = new SinhVien(id, hoTen, diaChi, gioiTinh, lop);
//            for (SinhVien sinhVien : listSinhVien) {
//                if (sinhVien.getId().equals(id)) {
//                    sinhVien.setLop(lop);
//                    sinhVien.setTen(hoTen);
//                    sinhVien.setGioiTinh(gioiTinh);
//                    sinhVien.setDiaChi(diaChi);
////                    sinhVien = sinhVienNew;
//                }
//            }
            response.sendRedirect("/sinh-vien/hien-thi");
        }

    }
}
