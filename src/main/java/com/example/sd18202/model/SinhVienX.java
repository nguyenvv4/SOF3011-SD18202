package com.example.sd18202.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVienX {
    private String ten;

    private String tenLop;

    @Override
    public String toString() {
        return "SinhVienX{" +
                "ten='" + ten + '\'' +
                ", tenLop='" + tenLop + '\'' +
                '}';
    }
}
