package com.example.sd18202.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
    private String id;

    private String ten;

    private String diaChi;

    private String gioiTinh;

    private String lop;

    private String chieuCao;

    private String canNang;

    public SinhVien(String id, String ten, String diaChi, String gioiTinh, String lop) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.lop = lop;
    }


}
