package com.aplikasi.karyawan.chp3.sesi2.optional;

import com.aplikasi.karyawan.chp3.sesi1.junit.model.Employee;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee();
//        employee.setName("Riki Aldi");
//        employee.setAddress("Jakarta jl");

        Optional<String> name = employee.getNameOptional();
        Optional<String> dob = employee.getDobtional();
        Optional<String> address = employee.getAddresstional();

        // Menggunakan ifPresent()
        name.ifPresent(n -> System.out.println("Nama: " + n));
        if(name != null){
            System.out.println("Nama: " +name);
        }
        dob.ifPresent(d -> System.out.println("Tanggal Lahir: " + d));
        address.ifPresent(a -> System.out.println("Alamat: " + a));

        // Menggunakan orElse()
        String nameOrDefault = name.orElse("Nama Default");
        System.out.println(nameOrDefault == null ? "null" :"tidak null");

        String dobOrDefault = dob.orElse("Tanggal Lahir Default");
        String addressOrDefault = address.orElse("Alamat Default");

        System.out.println("Nama (default jika null): " + nameOrDefault);
        System.out.println("Tanggal Lahir (default jika null): " + dobOrDefault);
        System.out.println("Alamat (default jika null): " + addressOrDefault);
    }
}
