package com.aplikasi.karyawan.chp3.sesi3.deto;

import com.aplikasi.karyawan.chp3.sesi1.junit.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoKaryawan {
   private int id;
    private String nama;

    public DtoKaryawan(Employee employee) {

    }

    public static DtoKaryawan getData(Employee karyawan) {
        DtoKaryawan p= new DtoKaryawan();
        p.setId(karyawan.getId());
        p.setNama(karyawan.getName());
        return p;
    }
}
