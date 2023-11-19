package com.example.sd18202.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// ten table == ten class
// ánh xa với bang lop trong sql
@Table(name = "lop")
// đánh dấu là 1 thực thể
@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LopHoc {

    // thuộc tính = thuộc tính trong class
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenLop")
    private String tenLop;
    // kiểu dữ liệu trong table == kiểu dữ liệu trong java
}
