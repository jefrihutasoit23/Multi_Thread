package com.aplikasi.karyawan.chp3.sesi1.junit.service.impl;


import com.aplikasi.karyawan.chp3.sesi1.junit.model.Employee;
import com.aplikasi.karyawan.chp3.sesi1.junit.service.EmployeeService;
import com.aplikasi.karyawan.chp3.sesi1.junit.utils.EmployeeNotFoundException;
import com.aplikasi.karyawan.chp3.sesi1.junit.utils.EmployeeNotFoundRunTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    @Override
    public String addEmployee(int id, String name, String dob, String address) {
        try {
            if(Objects.equals(name,null) || Objects.equals(name,"")){
                throw new EmployeeNotFoundRunTime("Nama Harus diisi");
            }
            if(Objects.equals(dob,null) || Objects.equals(dob,"")){
                throw new EmployeeNotFoundRunTime("dob Harus diisi");
            } if(Objects.equals(address,null) || Objects.equals(address,"")){
                throw new EmployeeNotFoundRunTime("address Harus diisi");
            }
            Employee employee = new Employee(id, name, dob, address);
            employees.add(employee);
            // berhasil simpan ke database
            return "Berhasil";
        }catch (EmployeeNotFoundRunTime e){
            System.out.println("eror saat simpan :"+e.getMessage());
            return e.getMessage();
        } finally {
            System.out.println("update");
            System.out.println("Selesai eksekusi simpa:");
        }

    }

    @Override
    public void updateEmployee(int id, String name, String dob, String address) throws EmployeeNotFoundException {
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setDob(dob);
                employee.setAddress(address);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        boolean removed = employees.removeIf(employee -> employee.getId() == id);
        if (!removed) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}