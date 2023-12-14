package com.aplikasi.karyawan.chp3.sesi3;

import com.aplikasi.karyawan.chp3.sesi1.junit.controller.EmployeeController;
import com.aplikasi.karyawan.chp3.sesi1.junit.model.Employee;
import com.aplikasi.karyawan.chp3.sesi1.junit.service.EmployeeService;
import com.aplikasi.karyawan.chp3.sesi1.junit.service.impl.EmployeeServiceImpl;
import com.aplikasi.karyawan.chp3.sesi3.deto.DtoKaryawan;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MethodReference {
    public static void main(String[] args) {
        // Contoh 1: Method reference untuk metode statis
        Function<String, Integer> parseInt = Integer::parseInt;

// Contoh 2: Method reference untuk metode instance
        Employee employee = new Employee();
        Supplier<String> getName = employee::getName;

// Contoh 3: Method reference untuk metode dalam antarmuka fungsional
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        names.forEach(System.out::println); // Menggunakan method reference pada System.out

        // Contoh 4: Method reference untuk metode instance
        Employee employeeID = new Employee();
        Supplier<Integer> getID = employee::getId;

        //contoh method reference  karyawan to DTOKaryawan
        EmployeeService employeeService = new EmployeeServiceImpl();
        EmployeeController controller = new EmployeeController(employeeService);

        // Menambahkan karyawan
        String data = controller.addEmployee(1, "riki", "1990-01-15", "Jakarta");
        String data2 = controller.addEmployee(2, "ALDI", "1985-05-20", "JAMBI");
        String data3 = controller.addEmployee(2, "PARI", "1985-05-20", "JAMBI");

        List<Employee> allEmployees = controller.getAllEmployees();
        List<DtoKaryawan> dtoKaryawanList = allEmployees.stream()
                .map(DtoKaryawan::new) // Menggunakan constructor DtoKaryawan yang menerima Employee
                .collect(Collectors.toList());

        //cara kedua
        List<DtoKaryawan> dtoKaryawanList2 = allEmployees.stream()
                .map(DtoKaryawan::getData) // Menggunakan constructor DtoKaryawan yang menerima Employee
                .collect(Collectors.toList());

        dtoKaryawanList2.stream().forEach(System.out::println);

        // memndahkan vaue dari list A ke list B
    }



}
/*
Method references (referensi metode) digunakan dalam bahasa pemrograman Java ketika Anda ingin mengacu pada metode (fungsi) yang sudah ada dalam sebuah kelas atau objek. Penggunaan method references membuat kode lebih ringkas dan ekspresif. Berikut adalah beberapa situasi di mana method references sangat berguna:

Menggantikan Lambda Expressions: Method references sering digunakan untuk menggantikan lambda expressions ketika Anda hanya ingin memanggil metode yang sudah ada tanpa menuliskan ekspresi lambda secara lengkap. Ini mengurangi kode yang berlebihan.

Menggunakan Antarmuka Fungsional: Method references sangat berguna ketika bekerja dengan antarmuka fungsional (functional interfaces). Anda dapat menggunakannya untuk mengimplementasikan metode dari antarmuka fungsional dengan cara yang lebih singkat.

Mengurangi Boilerplate Code: Method references membantu mengurangi boilerplate code (kode repetitif) dalam kasus-kasus tertentu, terutama ketika Anda perlu memanggil metode berulang-ulang.

Menggunakan Stream API: Method references dapat digunakan dalam operasi-operasi Stream API seperti map, filter, forEach, dan lainnya, untuk memproses data dengan cara yang lebih deklaratif.

Penggunaan Metode Statis: Anda dapat menggunakan method references untuk mengakses metode statis dalam sebuah kelas tanpa harus membuat objek dari kelas tersebut.

Menggunakan Metode Instans: Anda dapat menggunakan method references untuk mengakses metode non-statis dalam sebuah objek yang sudah ada.
 */