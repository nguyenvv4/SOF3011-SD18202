package com.example.sd18202.servlet;

import com.example.sd18202.model.LopHoc;
import com.example.sd18202.model.SinhVien;
import com.example.sd18202.model.SinhVienViewModel;
import com.example.sd18202.service.LopHocService;
import com.example.sd18202.service.SinhVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
        ArrayList<LopHoc> dslh = lopHocService.getListLopHoc();
        if (uri.contains("/hien-thi")) {
            // lấy list sinh viên từ bên service thông qua hàm getList()
            ArrayList<SinhVien> listSinhVien = sinhVienService.getList();
            request.setAttribute("listSinhVien", listSinhVien);
            request.setAttribute("dslh", dslh);
            request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            // truyen id sang service
            SinhVien sinhVienDetail = sinhVienService.getById(id);

            request.setAttribute("sinhVien", sinhVienDetail);
            request.setAttribute("dslh", dslh);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            sinhVienService.delete(id);
            response.sendRedirect("/sinh-vien/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            // bước 1: lấy thông tin trên form xuống
            SinhVienViewModel sinhVienViewModel = new SinhVienViewModel();
            try {
                BeanUtils.populate(sinhVienViewModel, request.getParameterMap());
                System.out.println(sinhVienViewModel.toString());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            // bước 2 tạo đối tượng từ thông tin vừa lấy
            SinhVien sinhVien = new SinhVien();
            sinhVien.copyProperties(sinhVienViewModel);
            // bước 3: add đối tượng vào danh sách
            sinhVienService.addNew(sinhVien);
            // bước 4 quay lại hiển thị
            response.sendRedirect("/sinh-vien/hien-thi");
        } else if (uri.contains("/update")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String hoTen = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            Integer idLop = Integer.parseInt(request.getParameter("lop"));
            LopHoc lop = new LopHoc();
            lop.setId(idLop);
            String gioiTinh = request.getParameter("gioiTinh");
            SinhVien sinhVienNew = new SinhVien();
            sinhVienNew.setId(id);
            sinhVienNew.setLop(lop);
            sinhVienNew.setTen(hoTen);
            sinhVienNew.setGioiTinh(gioiTinh);
            sinhVienNew.setDiaChi(diaChi);
            // truyen sang service
            sinhVienService.update(sinhVienNew);
            response.sendRedirect("/sinh-vien/hien-thi");
        }

    }
}
