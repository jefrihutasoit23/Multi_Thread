package com.aplikasi.karyawan.chp3.sesi1.junit.controller;


import com.aplikasi.karyawan.chp3.sesi1.junit.model.Employee;
import com.aplikasi.karyawan.chp3.sesi1.junit.service.EmployeeService;
import com.aplikasi.karyawan.chp3.sesi1.junit.utils.EmployeeNotFoundException;

import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String addEmployee(int id, String name, String dob, String address) {
        String data=  employeeService.addEmployee(id, name, dob, address);
//        System.out.println("datahasilnya=+data");
        return data;
    }

    public void updateEmployee(int id, String name, String dob, String address) throws EmployeeNotFoundException {
        employeeService.updateEmployee(id, name, dob, address);
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        employeeService.deleteEmployee(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}