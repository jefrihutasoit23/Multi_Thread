package com.aplikasi.karyawan.service;

import com.aplikasi.karyawan.entity.Employee;
import com.aplikasi.karyawan.entity.Rekening;

import java.util.Map;

public interface RekeningService {
    //
    Map save(Rekening request);

    Map update(Rekening request);

    Map delete(Rekening request);


    Map deleteUpdateTransactional(Rekening request);
}
