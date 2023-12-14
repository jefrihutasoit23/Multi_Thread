package com.aplikasi.karyawan.service;

import com.aplikasi.karyawan.entity.KaryawanTraining;
import com.aplikasi.karyawan.entity.Training;

import java.util.Map;

public interface EmployeeTrainingService {
    //
    Map save(KaryawanTraining request);

    Map update(KaryawanTraining request);

    Map delete(KaryawanTraining request);
}
