package com.example.sd18202.repository;

import com.example.sd18202.model.SinhVien;
import com.example.sd18202.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SinhVienRepository {
    public ArrayList<SinhVien> getList() {
        ArrayList<SinhVien> ketQua = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            ketQua = (ArrayList<SinhVien>) session.createQuery("from SinhVien").list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    public void addNew(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }
}
