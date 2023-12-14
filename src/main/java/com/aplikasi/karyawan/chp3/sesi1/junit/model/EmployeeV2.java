package com.aplikasi.karyawan.chp3.sesi1.junit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeV2 {
    private int id;
    private String name;
    private String dob;
    private String address;

    private  KaryawanDetail karyawanDetail;

//    public Employee(int id, String name, String dob, String address) {
//        this.id = id;
//        this.name = name;
//        this.dob = dob;
//        this.address = address;
//    }

    public Optional<String> getNameOptional() {
        return Optional.ofNullable(name);
    }

    public Optional<String> getDobtional() {
        return Optional.ofNullable(dob);
    }

    public Optional<String> getAddresstional() {
        return Optional.ofNullable(address);
    }
}

