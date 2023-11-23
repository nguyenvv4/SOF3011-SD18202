package com.example.sd18202.service;

import com.example.sd18202.model.SinhVien;
import com.example.sd18202.repository.SinhVienRepository;

import java.util.ArrayList;

public class SinhVienService {
    SinhVienRepository sinhVienRepository = new SinhVienRepository();
    // call repo
    public ArrayList<SinhVien> getList() {
        // lấy list sinh viên từ repo
        return sinhVienRepository.getList();
    }

    public  void addNew(SinhVien sinhVien){
        sinhVienRepository.addNew(sinhVien);
    }
}
