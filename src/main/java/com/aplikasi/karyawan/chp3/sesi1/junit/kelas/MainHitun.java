package com.aplikasi.karyawan.chp3.sesi1.junit.kelas;

public class MainHitun {
    public static void main(String[] args) {
        Hitung obj = new Hitung();
        obj.hitungTry(null,1); // eksekusi 2

        obj.hitung(null,1); // eksekusi 1 - gagal

        obj.hitungTryFinally(null,1); // eksekusi 1 - gagal

//        obj.arrayNama();
    }
}
