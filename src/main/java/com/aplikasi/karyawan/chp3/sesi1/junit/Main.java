package com.aplikasi.karyawan.chp3.sesi1.junit;



import com.aplikasi.karyawan.chp3.sesi1.junit.controller.EmployeeController;
import com.aplikasi.karyawan.chp3.sesi1.junit.model.Employee;
import com.aplikasi.karyawan.chp3.sesi1.junit.service.EmployeeService;
import com.aplikasi.karyawan.chp3.sesi1.junit.service.impl.EmployeeServiceImpl;
import com.aplikasi.karyawan.chp3.sesi1.junit.utils.EmployeeNotFoundException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws EmployeeNotFoundException {
        EmployeeService employeeService = new EmployeeServiceImpl();
        EmployeeController controller = new EmployeeController(employeeService);

        // Menambahkan karyawan
        String data = controller.addEmployee(1, null, "1990-01-15", "Jakarta");
        System.out.println("hasil dari RuntimeException=" + data);
        String data2 =  controller.addEmployee(2, "ALDI", "1985-05-20", "JAMBI");
        System.out.println("hasil dari RuntimeException vrsi 2=" + data2);

        // Menampilkan semua karyawan
        List<Employee> allEmployees = controller.getAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Date of Birth: " + employee.getDob());
            System.out.println("Address: " + employee.getAddress());
            System.out.println("--------------------");
        }

        // Mengubah data karyawan
        controller.updateEmployee(1, "BUDI", "1990-01-15", "KAMPAR");

        // Menampilkan semua karyawan setelah perubahan
        allEmployees = controller.getAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Date of Birth: " + employee.getDob());
            System.out.println("Address: " + employee.getAddress());
            System.out.println("--------------------");
        }

        // Menghapus karyawan
        controller.deleteEmployee(2);

        // Menampilkan semua karyawan setelah penghapusan
        allEmployees = controller.getAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Date of Birth: " + employee.getDob());
            System.out.println("Address: " + employee.getAddress());
            System.out.println("--------------------");
        }
    }
}