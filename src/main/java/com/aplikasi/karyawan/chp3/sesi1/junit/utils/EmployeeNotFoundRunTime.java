package com.aplikasi.karyawan.chp3.sesi1.junit.utils;

public class EmployeeNotFoundRunTime extends RuntimeException { // ga perlu
    public EmployeeNotFoundRunTime(String message) {
        super(message);
        System.out.println("Terjadi Eror="+message);
    }
}
