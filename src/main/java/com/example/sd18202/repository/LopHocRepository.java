package com.example.sd18202.repository;

import com.example.sd18202.model.LopHoc;
import com.example.sd18202.model.SinhVien;
import com.example.sd18202.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;

public class LopHocRepository {

    public ArrayList<LopHoc> getList() {
        ArrayList<LopHoc> ketQua = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            ketQua = (ArrayList<LopHoc>) session.createQuery("from LopHoc").list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
