package com.example.sd18202.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {

    private String id;

    private String hoTen;

    private String diaChi;

    private Integer tuoi;

    private String chucVu;

    private String gioiTinh;

    private Integer luong;
}
