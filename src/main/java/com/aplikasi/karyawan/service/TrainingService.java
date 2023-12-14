package com.aplikasi.karyawan.service;

import com.aplikasi.karyawan.entity.Rekening;
import com.aplikasi.karyawan.entity.Training;

import java.util.Map;

public interface TrainingService {
    //
    Map save(Training request);

    Map update(Training request);

    Map delete(Training request);
}
