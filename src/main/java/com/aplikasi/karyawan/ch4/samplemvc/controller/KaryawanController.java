package com.aplikasi.karyawan.ch4.samplemvc.controller;

import com.aplikasi.karyawan.ch4.samplemvc.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;

public class KaryawanController {

    @Autowired
    public KaryawanService karyawanService;
}
