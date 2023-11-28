package com.example.sd18202.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVienViewModel {

    private String hoTen;


    private String diaChi;


    private String gioiTinh;


    private Integer lop;

    @Override
    public String toString() {
        return "SinhVienViewModel{" +
                "hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", lop=" + lop +
                '}';
    }
}
