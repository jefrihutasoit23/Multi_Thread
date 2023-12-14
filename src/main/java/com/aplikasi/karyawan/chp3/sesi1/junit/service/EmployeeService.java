package com.aplikasi.karyawan.chp3.sesi1.junit.service;


import com.aplikasi.karyawan.chp3.sesi1.junit.model.Employee;
import com.aplikasi.karyawan.chp3.sesi1.junit.utils.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    String  addEmployee(int id, String name, String dob, String address);

    void updateEmployee(int id, String name, String dob, String address) throws EmployeeNotFoundException;

    void deleteEmployee(int id) throws EmployeeNotFoundException;

    List<Employee> getAllEmployees();


}