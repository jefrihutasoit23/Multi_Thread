package com.aplikasi.karyawan.chp3.sesi4;

import com.aplikasi.karyawan.chp3.sesi1.junit.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeStreamOperations {
    public static void main(String[] args) {
        // Contoh List objek Employee
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "RIKI", "1990-01-15", "123 Main St")); // 33
        employees.add(new Employee(2, "ALDI", "1985-03-20", "456 Elm St"));  // 38
        employees.add(new Employee(3, "PARI", "1992-07-10", "789 Oak St")); // 31

        // forEach(): Menggunakan forEach untuk mencetak nama-nama Employee
        System.out.println("Nama-nama Employee:");
        System.out.println("employees size="+employees.size());
        employees.stream()
                .forEach(employee -> System.out.println(employee.getName()));

        // toArray(): Mengubah Stream menjadi array
        Employee[] employeeArray = employees.stream()
                .toArray(Employee[]::new);

        // reduce(): Menggunakan reduce untuk menghitung total umur Employee
        int totalAge = employees.stream()
                .mapToInt(employee -> calculateAge(employee.getDob()))
                .reduce(0, Integer::sum);
        System.out.println("Total Umur Employee: " + totalAge);

        // collect(): Mengumpulkan nama-nama Employee dalam List
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Nama-nama Employee: " + employeeNames);

        // min() dan max(): Menemukan Employee dengan umur tertua dan termuda
        Optional<Employee> oldestEmployee = employees.stream()
                .min((e1, e2) -> Integer.compare(calculateAge(e1.getDob()), calculateAge(e2.getDob())));
        oldestEmployee.ifPresent(employee -> System.out.println("Employee dengan Umur Tertua: " + employee.getName()));

        Optional<Employee> youngestEmployee = employees.stream()
                .max((e1, e2) -> Integer.compare(calculateAge(e1.getDob()), calculateAge(e2.getDob())));
        youngestEmployee.ifPresent(employee -> System.out.println("Employee dengan Umur Termuda: " + employee.getName()));

        // count(): Menghitung jumlah Employee
        long employeeCount = employees.stream().count();
        System.out.println("Jumlah Employee: " + employeeCount);

        // anyMatch(), allMatch(), noneMatch(): Memeriksa kondisi pada setiap Employee
        boolean isAnyAbove30 = employees.stream().anyMatch(employee -> calculateAge(employee.getDob()) > 30);
        System.out.println("Ada Employee di atas 30 tahun: " + isAnyAbove30);

        boolean isAllAbove25 = employees.stream().allMatch(employee -> calculateAge(employee.getDob()) > 25); // semua employye
        System.out.println("Semua Employee di atas 25 tahun: " + isAllAbove25);

        boolean isNoneAbove40 = employees.stream().noneMatch(employee -> calculateAge(employee.getDob()) > 30);
        System.out.println("Tidak ada Employee di atas 40 tahun: " + isNoneAbove40);

        // findFirst() dan findAny(): Mendapatkan Employee pertama atau apa pun
        Optional<Employee> firstEmployee = employees.stream().findFirst();
        firstEmployee.ifPresent(employee -> System.out.println("Employee Pertama: " + employee.getName()));

        Optional<Employee> anyEmployee = employees.stream().findAny();
        anyEmployee.ifPresent(employee -> System.out.println("Employee Apa Pun: " + employee.getName()));
    }

    // Metode untuk menghitung umur berdasarkan tanggal lahir
    private static int calculateAge(String dob) {
        // Implementasi perhitungan umur di sini
        // Contoh sederhana: Ambil tahun dari tanggal lahir dan kurangkan dengan tahun sekarang
        int birthYear = Integer.parseInt(dob.split("-")[0]);
        int currentYear = java.time.Year.now().getValue(); //2023
//        System.out.println("currentYear="+currentYear);
        return currentYear - birthYear;
    }
}
