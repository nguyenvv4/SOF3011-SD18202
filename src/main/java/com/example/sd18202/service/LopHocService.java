package com.example.sd18202.service;

import com.example.sd18202.model.LopHoc;
import com.example.sd18202.repository.LopHocRepository;

import java.util.ArrayList;

public class LopHocService {

    LopHocRepository lopHocRepository = new LopHocRepository();

    public ArrayList<LopHoc> getListLopHoc() {
        return lopHocRepository.getList();
    }
}
