package com.aplikasi.karyawan.chp3.sesi2.optional;

import com.aplikasi.karyawan.chp3.sesi1.junit.model.EmployeeV2;
import com.aplikasi.karyawan.chp3.sesi1.junit.model.KaryawanDetail;

public class MainKelas {
    public static void main(String[] args) {
        EmployeeV2 employee = new EmployeeV2();
        KaryawanDetail karyawanDetail = new KaryawanDetail();
        karyawanDetail.setId(1);
        karyawanDetail.setNik("123");
        employee.setKaryawanDetail(karyawanDetail);
        if (employee.getKaryawanDetail() != null) {
            if (employee.getKaryawanDetail().getNik().equals("123")) {
                System.out.println("nilai =" + employee.getKaryawanDetail().getNik());
            } else {
                System.out.println("keluar =" + employee.getId());
            }
        }else {
            System.out.println("Nilai NIK NULL");
        }


//        if (employee.getKaryawanDetail() != null) {
//            if (employee.getKaryawanDetail().getDetail2() != null) {
//                if(employee.getKaryawanDetail().getDetail2().getRekening().equals("BCA")){
//                    System.out.println("print hasil="+employee.getKaryawanDetail().getDetail2().getRekening());
//                }
//            }
//        }
//
//        try {
//            /*
//            logic benar
//            simpan
//             */
//            if(Objects.equals(employee.getKaryawanDetail().getDetail2().getRekening(),"BCA")){
//                System.out.println("hasil2");
//            }
//        }catch (Exception e){
//            /*
//            lari kesini apapun yang kesalahanya.
//             */
//            System.out.println("eror="+e.getMessage());
//        }


        String chekEquals = (employee.getKaryawanDetail().getDetail2().getRekening().equals("BCA") ? "ADA ISI":"NULL");
        System.out.println("chekEquals="+chekEquals);


    }
}
