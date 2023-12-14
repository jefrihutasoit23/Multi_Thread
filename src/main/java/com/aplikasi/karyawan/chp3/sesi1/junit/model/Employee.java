package com.aplikasi.karyawan.chp3.sesi1.junit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String dob;
    private String address;

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

    public Optional<Long> getUmurOptional() {
        return Optional.ofNullable(123l);
    }

    public static void printStaticDetails(Employee employee) {
        System.out.println("ID: " + employee.getId());
        System.out.println("Nama: " + employee.getName());
        System.out.println("Alamat: " + employee.getAddress());
    }

//    private  List<String> listNama;
//    public Optional<List<String>> getListnama(){
//        return Optional.ofNullable(listNama);
//    }
//
//    public Optional<List<String>> setListnama(List<String> listNama){
//        return Optional.ofNullable(listNama);
//    }
}

