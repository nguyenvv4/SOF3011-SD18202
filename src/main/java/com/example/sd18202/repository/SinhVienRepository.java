package com.example.sd18202.repository;

import com.example.sd18202.model.SinhVien;
import com.example.sd18202.model.SinhVienX;
import com.example.sd18202.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Queue;

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

    public void update(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public SinhVien getById(Integer id) {
        SinhVien sinhVien = new SinhVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from  SinhVien where id = :id");
            query.setParameter("id", id);
            sinhVien = (SinhVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sinhVien;
    }

    public void delete(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }


    public ArrayList<SinhVienX> getX() {
        ArrayList<SinhVienX> sinhVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select new com.example.sd18202.model.SinhVienX(s.ten,l.tenLop)" +
                    " from com.example.sd18202.model.SinhVien s " +
                    " join com.example.sd18202.model.LopHoc l " +
                    " on s.lop.id = l.id");
            sinhVien = (ArrayList<SinhVienX>) query.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sinhVien;
    }

    public static void main(String[] args) {
        SinhVienRepository sinhVienRepository = new SinhVienRepository();
        ArrayList<SinhVien> list = sinhVienRepository.getList();
        for (SinhVien sinhVien : list) {
            System.out.println(sinhVien.getTen() + " - " + sinhVien.getLop().getTenLop());
        }
        System.out.println("=========");
        ArrayList<SinhVienX> x = sinhVienRepository.getX();
        for (SinhVienX sinhVienX : x){
            System.out.println(sinhVienX.toString());
        }
     }
}
