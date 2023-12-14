package com.aplikasi.karyawan.chp3.sesi3;

import com.aplikasi.karyawan.chp3.sesi1.junit.controller.EmployeeController;
import com.aplikasi.karyawan.chp3.sesi1.junit.model.Employee;
import com.aplikasi.karyawan.chp3.sesi1.junit.service.EmployeeService;
import com.aplikasi.karyawan.chp3.sesi1.junit.service.impl.EmployeeServiceImpl;
import com.aplikasi.karyawan.chp3.sesi1.junit.utils.EmployeeNotFoundException;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ContohLamdaKaryawan {
    public static void main(String[] args) throws EmployeeNotFoundException {
        EmployeeService employeeService = new EmployeeServiceImpl();
        EmployeeController controller = new EmployeeController(employeeService);

        // Menambahkan karyawan
        String data = controller.addEmployee(1, "riki", "1990-01-15", "Jakarta");
//        System.out.println("hasil dari RuntimeException=" + data);
        String data2 =  controller.addEmployee(2, "ALDI", "1985-05-20", "JAMBI");

        String data3 =  controller.addEmployee(2, "PARI", "1985-05-20", "JAMBI");
//        System.out.println("hasil dari RuntimeException vrsi 2=" + data2);

        // Menampilkan semua karyawan
        List<Employee> allEmployees = controller.getAllEmployees();
//        allEmployees.forEach((k ->{
//            if(k.getName().equals("riki")){
//                k.setName("nama yang dirubah");
//            }
//
//
//        }));
//        for (Employee employee : allEmployees) {
//            System.out.println("ID: " + employee.getId());
//            System.out.println("Name: " + employee.getName());
//            System.out.println("Date of Birth: " + employee.getDob());
//            System.out.println("Address: " + employee.getAddress());
//            System.out.println("--------------------");
//        }
//
//        // Mengubah data karyawan
//        controller.updateEmployee(1, "BUDI", "1990-01-15", "KAMPAR");
//
//        // Menampilkan semua karyawan setelah perubahan
//        allEmployees = controller.getAllEmployees();
//        for (Employee employee : allEmployees) {
//            System.out.println("ID: " + employee.getId());
//            System.out.println("Name: " + employee.getName());
//            System.out.println("Date of Birth: " + employee.getDob());
//            System.out.println("Address: " + employee.getAddress());
//            System.out.println("--------------------");
//        }
//
//        // Menghapus karyawan
//        controller.deleteEmployee(2);
//
//        // Menampilkan semua karyawan setelah penghapusan
//        allEmployees = controller.getAllEmployees();
//        for (Employee employee : allEmployees) {
//            System.out.println("ID: " + employee.getId());
//            System.out.println("Name: " + employee.getName());
//            System.out.println("Date of Birth: " + employee.getDob());
//            System.out.println("Address: " + employee.getAddress());
//            System.out.println("--------------------");
//        }

        // 1.Menggunakan lambda untuk melakukan filter pada daftar Karyawan
        List<Employee> filteredEmployees = allEmployees.stream()
//                .filter(employee -> employee.getName().contains("ri"))
                .collect(Collectors.toList());
//  (param) -> {action}
        // 2.Menggunakan lambda untuk mengurutkan daftar Karyawan berdasarkan nama
        filteredEmployees.sort((e1, e2) -> e2.getName().compareTo(e1.getName()));

        // Desc ?
        filteredEmployees.removeIf(k -> k.getName().equals("ALDI"));

        filteredEmployees.stream().forEach((k->{
            System.out.println(""+k.getName());
        }));



//        //3. Lamda dalam map
//        Map<Integer, Employee> employeeMap = new HashMap<>();
//// Menambahkan Karyawan ke dalam peta dengan lambda
//        employeeMap.put(1, new  Employee(1, "riki", "01-01-1998", "jakarta"));
//        employeeMap.put(2, new  Employee(2, "Aldi", "01-01-1998", "jakarta"));
//        employeeMap.put(3, new  Employee(3, "Pari", "01-01-1998", "jakarta"));
//
//// Menggunakan lambda untuk mendapatkan Karyawan berdasarkan ID : Nilai default
//        Employee foundEmployee = employeeMap.getOrDefault(4, new  Employee(1, "riki", "01-01-1998", "jakarta"));
//
//        System.out.println("foundEmployee="+foundEmployee.getName());
    }
}
