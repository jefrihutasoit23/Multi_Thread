package com.aplikasi.karyawan.ch4.samplemvc.service.impl;

import com.aplikasi.karyawan.ch4.samplemvc.entity.Karyawan;
import com.aplikasi.karyawan.ch4.samplemvc.service.KaryawanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KaryawanImpl implements KaryawanService {
    @Override
    public List<Karyawan> getList() {
        // ada logic
        return null;
    }
}
