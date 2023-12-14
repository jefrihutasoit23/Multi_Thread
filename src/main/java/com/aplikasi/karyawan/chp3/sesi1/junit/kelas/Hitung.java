package com.aplikasi.karyawan.chp3.sesi1.junit.kelas;

public class Hitung {
    public void hitung(Integer angka, Integer angkab){
        if(angka !=null){
            int getAngka = angka;
            int getAngkb = angkab;
            System.out.println(getAngka+getAngkb);
        }else {
            System.out.println("ada angka yang null");
        }
    }

    public void arrayNama(){
        String[] nama={"fori","farel","erki"};

        System.out.println(nama[1]);
        System.out.println(nama[6]);
    }


    public void hitungTry(Integer angka, Integer angkab){
        try {
            int getAngka = angka;
            int getAngkb = angkab;
            System.out.println(getAngka+getAngkb);
        }catch (Exception e){
            System.out.println("eror="+e.getMessage());
        }
    }

    public void hitungTryFinally(Integer angka, Integer angkab){
        try {
            int getAngka = angka;
            int getAngkb = angkab;
            System.out.println(getAngka+getAngkb);
        }catch (Exception e){
            System.out.println("eror finally="+e.getMessage());
        }finally {
            System.out.println("selesai mengerjakan method hitung");
        }
    }
}
